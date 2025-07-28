package com.nest.renting.web.admin.vo.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents the basic information of an employee.
 * This class is used to encapsulate the essential details of a system user,
 * such as the user's name and avatar URL.
 */
@Schema(description = "Basic Employee Information")
@Data
public class SystemUserInfoVo {

    /**
     * The name of the user.
     */
    @Schema(description = "User name")
    private String name;

    /**
     * The URL of the user's avatar.
     */
    @Schema(description = "User avatar URL")
    private String avatarUrl;
}
