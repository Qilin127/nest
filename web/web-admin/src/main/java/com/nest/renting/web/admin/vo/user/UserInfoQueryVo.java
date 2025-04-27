package com.nest.renting.web.admin.vo.user;

import com.nest.renting.model.enums.BaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User Information Query Object")
@Data
public class UserInfoQueryVo {

    @Schema(description = "User phone number")
    private String phone;

    @Schema(description = "User account status")
    private BaseStatus status;
}
