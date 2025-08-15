package com.nest.renting.web.admin.vo.user;

import com.nest.renting.model.enums.BaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents a query object for user information.
 * This class is used to encapsulate the query criteria when searching for user information.
 * It includes fields for user phone number and user account status.
 */
@Schema(description = "User Information Query Object")
@Data
public class UserInfoQueryVo {

    /**
     * The phone number of the user.
     * This field is used as a query criterion to search for users by their phone number.
     */
    @Schema(description = "User phone number")
    private String phone;

    /**
     * The account status of the user.
     * This field is used as a query criterion to search for users based on their account status.
     * The status is defined by the {@link com.nest.renting.model.enums.BaseStatus} enumeration.
     */
    @Schema(description = "User account status")
    private BaseStatus status;
}
