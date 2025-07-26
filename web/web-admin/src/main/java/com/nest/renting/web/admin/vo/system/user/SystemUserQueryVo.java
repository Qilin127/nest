package com.nest.renting.web.admin.vo.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents the query object for employees. This class is used to encapsulate
 * the query parameters when searching for employee information.
 */
@Data
@Schema(description = "Employee Query Object")
public class SystemUserQueryVo {

    /**
     * The name of the employee to query. If provided, the query will filter
     * employees by this name.
     */
    @Schema(description = "Employee name")
    private String name;

    /**
     * The phone number of the employee to query. If provided, the query will filter
     * employees by this phone number.
     */
    @Schema(description = "Phone number")
    private String phone;
}
