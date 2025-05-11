package com.nest.renting.web.admin.service.impl;

import com.nest.renting.common.minio.MinioProperties;
import com.nest.renting.web.admin.service.FileService;
import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private MinioProperties minioProperties;

    @Override
    public String upload(MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // Create a bucket
        boolean bucketExists = minioClient.bucketExists(BucketExistsArgs
                .builder()
                .bucket(minioProperties.getBucketName())
                .build());
        if (!bucketExists) { // The bucket is created if it does not exist
            minioClient.makeBucket(MakeBucketArgs
                    .builder()
                    .bucket(minioProperties.getBucketName())
                    .build());
            // Set permissions (allow yourself to write and others to read)
            minioClient.setBucketPolicy(SetBucketPolicyArgs
                    .builder()
                    .bucket(minioProperties.getBucketName())
                    .config(createBucketPolicyConfig(minioProperties.getBucketName()))
                    .build());
        }

        // Define the unique file name of the file in Minio
        String filename = new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
        // Upload the file to the bucket
        minioClient.putObject(PutObjectArgs
                .builder()
                .bucket(minioProperties.getBucketName())
                .stream(file.getInputStream(), file.getSize(), -1)
                .object(filename)
                .contentType(file.getContentType())
                .build());

        return String.join("/", minioProperties.getEndpoint(), minioProperties.getBucketName(), filename);
    }

    /**
     * Everyone is allowed to read the content of the bucketName bucket.
     * By default, only oneself is permitted to write
     */
    private String createBucketPolicyConfig(String bucketName) {

        return """
                {
                  "Statement" : [ {
                    "Action" : "s3:GetObject",
                    "Effect" : "Allow",
                    "Principal" : "*",
                    "Resource" : "arn:aws:s3:::%s/*"
                  } ],
                  "Version" : "2012-10-17"
                }
                """.formatted(bucketName);
    }
}
