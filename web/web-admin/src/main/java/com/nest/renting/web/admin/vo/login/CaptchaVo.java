package com.nest.renting.web.admin.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents the image captcha information used during the login process.
 * This class encapsulates the captcha image and its corresponding key.
 */
@Data
@Schema(description = "Image Captcha")
@AllArgsConstructor
public class CaptchaVo {

    /**
     * The captcha image, encoded in Base64 format.
     */
    @Schema(description = "Captcha image (Base64 encoded)")
    private String image;

    /**
     * The unique key associated with the captcha image.
     * This key is used to verify the user's input against the correct captcha value.
     */
    @Schema(description = "Captcha key")
    private String key;
}
