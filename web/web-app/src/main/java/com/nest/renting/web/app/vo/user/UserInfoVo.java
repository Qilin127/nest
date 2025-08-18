package com.nest.renting.web.app.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * UserInfoVo represents basic user information, including nickname and avatar URL.
 */
@Schema(description = "Basic User Information")
@Data
@AllArgsConstructor
public class UserInfoVo {

    @Schema(description = "User Nickname")
    private String nickname;

    @Schema(description = "User Avatar URL")
    private String avatarUrl;

}