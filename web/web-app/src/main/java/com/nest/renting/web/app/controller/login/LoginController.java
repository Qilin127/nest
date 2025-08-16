package com.nest.renting.web.app.controller.login;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import com.nest.renting.common.result.Result;

@RestController
@Tag(name = "Login Management")
@RequestMapping("/app/")
public class LoginController {

    @GetMapping("/login/getCode")
    @Operation(summary = "Get SMS verification code")
    public Result getCode(@RequestParam String phone) {
        return Result.ok();
    }

    @PostMapping("/login")
    @Operation(summary = "Log in")
    public Result login() {
        return Result.ok();
    }

    @GetMapping("/info")
    @Operation(summary = "Get logged-in user information")
    public Result info() {
        return Result.ok();
    }
}
