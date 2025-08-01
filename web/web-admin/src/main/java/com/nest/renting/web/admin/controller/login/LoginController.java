package com.nest.renting.web.admin.controller.login;

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
    private LoginService service;

    @Operation(summary = "Retrieve graphical captcha")
    @GetMapping("login/captcha")
    public Result<CaptchaVo> getCaptcha() {
        CaptchaVo captcha = service.getCaptcha();
        return Result.ok(captcha);
    }

    @Operation(summary = "Login")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        return Result.ok();
    }

    @Operation(summary = "Get personal information of the logged-in user")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info() {
        return Result.ok();
    }

}