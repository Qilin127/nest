package com.nest.renting.web.admin.controller.login;

import com.nest.renting.common.login.LoginUserHolder;
import com.nest.renting.common.result.Result;
import com.nest.renting.web.admin.service.LoginService;
import com.nest.renting.web.admin.vo.login.CaptchaVo;
import com.nest.renting.web.admin.vo.login.LoginVo;
import com.nest.renting.web.admin.vo.system.user.SystemUserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Login management for the backend admin system")
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "Retrieve graphical captcha")
    @GetMapping("login/captcha")
    public Result<CaptchaVo> getCaptcha() {
        CaptchaVo captchaVo = loginService.getCaptcha();
        return Result.ok(captchaVo);
    }

    @Operation(summary = "Login")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        String jwt = loginService.login(loginVo);
        return Result.ok(jwt);
    }

    @Operation(summary = "Get personal information of the logged-in user")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info() {
        Long userId = LoginUserHolder.getLoginUser().getUserId();
        SystemUserInfoVo systemUserInfoVo = loginService.getLoginUserInfoById(userId);
        return Result.ok(systemUserInfoVo);
    }

}