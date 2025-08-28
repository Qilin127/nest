package com.nest.renting.web.app.service;

import com.nest.renting.web.app.vo.user.LoginVo;
import com.nest.renting.web.app.vo.user.UserInfoVo;

public interface LoginService {
    void getCode(String phone);

    String login(LoginVo loginVo);

    UserInfoVo getLoginUserById(Long userId);
}
