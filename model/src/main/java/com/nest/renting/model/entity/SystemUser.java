package com.nest.renting.model.entity;

import com.nest.renting.model.enums.BaseStatus;
import com.nest.renting.model.enums.SystemUserType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents the employee information within the system.
 * This entity class maps to the "system_user" table in the database.
 * It extends the BaseEntity class, inheriting common fields such as creation and modification timestamps.
 */
@Schema(description = "Employee Information")
@TableName(value = "system_user")
@Data
public class SystemUser extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     * This field ensures that the same class version is used during serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The username used by the employee to log in to the system.
     */
    @Schema(description = "Username")
    @TableField(value = "username")
    private String username;

    /**
     * The password associated with the employee's account.
     * The 'select = false' attribute indicates that this field will not be retrieved by default in SQL queries.
     */
    @Schema(description = "Password")
    @TableField(value = "password", select = false)
    private String password;

    /**
     * The full name of the employee.
     */
    @Schema(description = "Full Name")
    @TableField(value = "name")
    private String name;

    /**
     * The type of the user account, defined by the SystemUserType enumeration.
     */
    @Schema(description = "User Type")
    @TableField(value = "type")
    private SystemUserType type;

    /**
     * The phone number of the employee.
     */
    @Schema(description = "Phone Number")
    @TableField(value = "phone")
    private String phone;

    /**
     * The URL of the employee's avatar image.
     */
    @Schema(description = "Avatar URL")
    @TableField(value = "avatar_url")
    private String avatarUrl;

    /**
     * Additional information related to the employee.
     */
    @Schema(description = "Additional Information")
    @TableField(value = "additional_info")
    private String additionalInfo;

    /**
     * The ID of the post the employee is assigned to.
     */
    @Schema(description = "Post ID")
    @TableField(value = "post_id")
    private Long postId;

    /**
     * The status of the employee's account, defined by the BaseStatus enumeration.
     */
    @Schema(description = "Account Status")
    @TableField(value = "status")
    private BaseStatus status;


}