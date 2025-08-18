package com.nest.renting.web.app.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * UserSubmitVo represents the entity for submitting user information updates, including nickname and avatar URL.
 */
@Data
@Schema(description = "User Information Update Entity")
public class UserSubmitVo {

    @Schema(description = "User Nickname")
    private String nickname;

    @Schema(description = "Avatar Image URL")
    private String avatarUrl;
}
