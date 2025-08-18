package com.nest.renting.web.app.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * LoginVo represents the login entity for the APP, including phone number and SMS verification code.
 */
@Data
@Schema(description = "Login Entity for APP")
public class LoginVo {

    @Schema(description = "Phone Number")
    private String phone;

    @Schema(description = "SMS Verification Code")
    private String code;
}