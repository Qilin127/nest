package com.nest.renting.web.admin.vo.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "Employee Query Object")
public class SystemUserQueryVo {

    @Schema(description = "Employee name")
    private String name;

    @Schema(description = "Phone number")
    private String phone;
}
