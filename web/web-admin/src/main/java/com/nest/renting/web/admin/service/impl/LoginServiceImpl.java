package com.nest.renting.web.admin.service.impl;

import com.nest.renting.common.constant.RedisConstant;
import com.nest.renting.common.exception.RentingException;
import com.nest.renting.common.result.ResultCodeEnum;
import com.nest.renting.common.utils.JwtUtil;
import com.nest.renting.model.entity.SystemUser;
import com.nest.renting.model.enums.BaseStatus;
import com.nest.renting.web.admin.mapper.SystemUserMapper;
import com.nest.renting.web.admin.service.LoginService;
import com.nest.renting.web.admin.vo.login.CaptchaVo;
import com.nest.renting.web.admin.vo.login.LoginVo;
import com.nest.renting.web.admin.vo.system.user.SystemUserInfoVo;
import com.wf.captcha.SpecCaptcha;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public CaptchaVo getCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        String code = specCaptcha.text().toLowerCase();

        String key = RedisConstant.ADMIN_LOGIN_PREFIX + UUID.randomUUID();

        stringRedisTemplate.opsForValue().set(key, code, RedisConstant.ADMIN_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);

        CaptchaVo captchaVo = new CaptchaVo(specCaptcha.toBase64(), key);

        return captchaVo;
    }


    @Override
    public String login(LoginVo loginVo) {

        if (loginVo == null) {
            throw new RentingException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
        }

        String correctCode = stringRedisTemplate.opsForValue().get(loginVo.getCaptchaKey());
        if (correctCode == null) {
            throw new RentingException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
        }

        if (!correctCode.equals(loginVo.getCaptchaCode().toLowerCase())) {
            throw new RentingException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_ERROR);
        }

        SystemUser systemUser = systemUserMapper.selectOneByUsername(loginVo.getUsername());
        if (systemUser == null) {
            throw new RentingException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }

        if (systemUser.getStatus() == BaseStatus.DISABLE) {
            throw new RentingException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
        }

        if (!systemUser.getPassword().equals(DigestUtils.md5Hex(loginVo.getPassword()))) {
            throw new RentingException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }

        String token = JwtUtil.createToken(systemUser.getId(), systemUser.getUsername());

        return token;
    }


    @Override
    public SystemUserInfoVo getLoginUserInfoById(Long userId) {
        SystemUser systemUser = systemUserMapper.selectById(userId);
        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        BeanUtils.copyProperties(systemUser, systemUserInfoVo);
        return systemUserInfoVo;
    }

}
