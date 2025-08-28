package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nest.renting.common.constant.RedisConstant;
import com.nest.renting.common.exception.RentingException;
import com.nest.renting.common.result.ResultCodeEnum;
import com.nest.renting.common.utils.JwtUtil;
import com.nest.renting.model.entity.UserInfo;
import com.nest.renting.model.enums.BaseStatus;
import com.nest.renting.web.app.mapper.UserInfoMapper;
import com.nest.renting.web.app.service.LoginService;
import com.nest.renting.web.app.service.SmsService;
import com.nest.renting.web.app.vo.user.LoginVo;
import com.nest.renting.web.app.vo.user.UserInfoVo;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SmsService smsService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * Generate a random verification code and send it to the user
     */
    @Override
    public void getCode(String phone) {
        // FIXME: The SMS function is not available for the time being
//        String key = RedisConstant.APP_LOGIN_PREFIX + phone;
//
//        // Limit the user's sending frequency (one message per minute)
//        if (redisTemplate.hasKey(key)) {
//            Long ttl = redisTemplate.getExpire(key, TimeUnit.SECONDS);
//            // If a user sends a text message request again within one minute, it should be rejected.
//            if (RedisConstant.APP_LOGIN_CODE_TTL_SEC - ttl < RedisConstant.APP_LOGIN_CODE_RESEND_TIME_SEC) {
//                throw new RentingException(ResultCodeEnum.APP_SEND_SMS_TOO_OFTEN);
//            }
//        }
//
//        // Get a random verification code.
//        String code = CodeUtil.generateCode(6);
//
//        // Save to Redis (with the mobile phone number as the key and the verification code as the value)
//        redisTemplate.opsForValue().set(key, code, RedisConstant.APP_LOGIN_CODE_TTL_SEC, TimeUnit.SECONDS);
//
//        smsService.sentCode(phone, code);

        String key = RedisConstant.APP_LOGIN_PREFIX + phone;

        // Limit the user's sending frequency (one message per minute).
        if (redisTemplate.hasKey(key)) {
            Long ttl = redisTemplate.getExpire(key, TimeUnit.SECONDS);
            // If a user sends a text message request again within one minute, it should be rejected.
            if (RedisConstant.APP_LOGIN_CODE_TTL_SEC - ttl < RedisConstant.APP_LOGIN_CODE_RESEND_TIME_SEC) {
                throw new RentingException(ResultCodeEnum.APP_SEND_SMS_TOO_OFTEN);
            }
        }

        // The verification code is fixed at 123456
        String code = "123456";

        // Save to redis (the mobile phone number is the key and the verification code is the value)
        redisTemplate.opsForValue().set(key, code, RedisConstant.APP_LOGIN_CODE_TTL_SEC, TimeUnit.SECONDS);

        // Do not send text SMS
    }

    /**
     * Verify whether the user's login is legal
     */
    @Override
    public String login(LoginVo loginVo) {
        // First, verify whether 'phone' and 'code' are empty. If they are empty, directly respond with 'phone number is empty' or 'verification code is empty'.
        // If they are not empty, proceed to the next step of judgment.
        if (loginVo.getPhone() == null) {
            throw new RentingException(ResultCodeEnum.APP_LOGIN_PHONE_EMPTY);
        }
        if (loginVo.getCode() == null) {
            throw new RentingException(ResultCodeEnum.APP_LOGIN_CODE_EMPTY);
        }

        // Query the previously saved verification code from Redis based on 'phone'.
        // If the query result is empty, directly respond with 'verification code has expired'.
        // If it is not empty, proceed to the next step of judgment.
        String key = RedisConstant.APP_LOGIN_PREFIX + loginVo.getPhone();
        String code = redisTemplate.opsForValue().get(key);
        if (code == null) {
            throw new RentingException(ResultCodeEnum.APP_LOGIN_CODE_EXPIRED);
        }

        // Compare the verification code sent from the front end with the one queried from Redis.
        // If they are different, directly respond with "Verification code error".
        // If they are the same, proceed to the next step of judgment.
        if (!code.equals(loginVo.getCode())) {
            throw new RentingException(ResultCodeEnum.APP_LOGIN_CODE_ERROR);
        }

        // Use 'phone' to query user information from the database.
        // If the query result is empty, create a new user, save the user to the database, and then proceed to the next judgment step.
        LambdaQueryWrapper<UserInfo> userInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userInfoLambdaQueryWrapper.eq(UserInfo::getPhone, loginVo.getPhone());
        UserInfo userInfo = userInfoMapper.selectOne(userInfoLambdaQueryWrapper);
        if (userInfo == null) {
            // Register for new users
            userInfo = new UserInfo();
            userInfo.setPhone(loginVo.getPhone());
            userInfo.setStatus(BaseStatus.ENABLE);
            userInfo.setNickname("user-" + loginVo.getPhone().substring(0,4));
            // FIXME: Save the user's default avatar
            userInfo.setAvatarUrl("http://192.168.230.101:9000/nest/public/default%20avatar.png");
            userInfoMapper.insert(userInfo);
        } else {
            // Determine whether the user has been disabled. If it is, directly respond with "Account disabled"; otherwise, proceed to the next step.
            if (userInfo.getStatus() == BaseStatus.DISABLE) {
                throw new RentingException(ResultCodeEnum.APP_ACCOUNT_DISABLED_ERROR);
            }
        }

        // Create a JWT and respond to it to the front end.
        String token = JwtUtil.createToken(userInfo.getId(), userInfo.getPhone());

        return token;
    }

    /**
     * User information is obtained through id, UserInfoVo, for front-end display
     */
    @Override
    public UserInfoVo getLoginUserById(Long userId) {
        UserInfo user = userInfoMapper.selectById(userId);
        UserInfoVo userInfoVo = new UserInfoVo(user.getNickname(), user.getAvatarUrl());
        return userInfoVo;
    }
}
