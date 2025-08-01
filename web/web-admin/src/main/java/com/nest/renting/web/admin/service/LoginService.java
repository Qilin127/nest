package com.nest.renting.web.admin.service;

import com.nest.renting.web.admin.vo.login.CaptchaVo;
import com.nest.renting.web.admin.vo.login.LoginVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);
}
