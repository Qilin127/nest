package com.nest.renting.web.admin.vo.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "Basic Employee Information")
@Data
public class SystemUserInfoVo {

    @Schema(description = "User name")
    private String name;

    @Schema(description = "User avatar URL")
    private String avatarUrl;
}
