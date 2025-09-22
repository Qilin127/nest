package com.nest.renting.web.app.controller.login;

import com.nest.renting.common.login.LoginUserHolder;
import com.nest.renting.web.app.service.LoginService;
import com.nest.renting.web.app.vo.user.LoginVo;
import com.nest.renting.web.app.vo.user.UserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nest.renting.common.result.Result;

@RestController
@Tag(name = "Login Management")
@RequestMapping("/app/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * Generate a random verification code and send it to the user
     */
    @GetMapping("/login/getCode")
    @Operation(summary = "Get SMS verification code")
    public Result getCode(@RequestParam String phone) {
        loginService.getCode(phone);
        return Result.ok();
    }

    /**
     * Verify whether the user's login is legal
     */
    @PostMapping("/login")
    @Operation(summary = "Log in")
    public Result login(@RequestBody LoginVo loginVo) {
        String token = loginService.login(loginVo);
        return Result.ok(token);
    }

    /**
     * User information is obtained through id, UserInfoVo, for front-end display
     */
    @GetMapping("/info")
    @Operation(summary = "Get logged-in user information")
    public Result info() {
        Long userId = LoginUserHolder.getLoginUser().getUserId();
        UserInfoVo userInfoVo = loginService.getLoginUserById(userId);
        return Result.ok(userInfoVo);
    }
}
