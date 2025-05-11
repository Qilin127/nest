package com.nest.renting.common.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MinioProperties.class)
@ConditionalOnProperty(name = "minio.endpoint")
public class MinioConfiguration {
    @Autowired
    private MinioProperties minioProperties;

    /**
     * Construct the Minio Client object to manage the Minio server
     */
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().
                endpoint(minioProperties.getEndpoint()).
                credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey()).
                build();
    }
}
