package com.nest.renting.web.admin.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * The unique key associated with the captcha image.
 * This key is used to verify the user's input against the correct captcha value.
 */
@Data
@Schema(description = "Login Information for Admin System")
public class LoginVo {

    /**
     * The username used by the admin user to log in.
     */
    @Schema(description = "Username")
    private String username;

    /**
     * The password corresponding to the admin user's account.
     */
    @Schema(description = "Password")
    private String password;

    /**
     * The captcha key, which is a UUID used as a key in Redis to store the captcha information.
     */
    @Schema(description = "Captcha key (UUID used as Redis key)")
    private String captchaKey;

    /**
     * The captcha code entered by the admin user for verification.
     */
    @Schema(description = "Captcha code")
    private String captchaCode;
}
