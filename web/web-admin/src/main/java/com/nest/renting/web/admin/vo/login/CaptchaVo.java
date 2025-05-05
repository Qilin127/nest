package com.nest.renting.web.admin.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "Image Captcha")
@AllArgsConstructor
public class CaptchaVo {

    // Convert the binary image to a Base64 string for frontend display
    // (Captcha images are small and blurry, so it's fine to send as a string)
    @Schema(description = "Captcha image (Base64 encoded)")
    private String image;

    @Schema(description = "Captcha key")
    private String key;
}
