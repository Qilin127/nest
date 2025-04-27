package com.nest.renting.model.entity;

import com.nest.renting.model.enums.BaseStatus;
import com.nest.renting.model.enums.SystemUserType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Employee Information")
@TableName(value = "system_user")
@Data
public class SystemUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Username")
    @TableField(value = "username")
    private String username;

    @Schema(description = "Password")
    @TableField(value = "password", select = false)
    private String password;

    @Schema(description = "Full Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "User Type")
    @TableField(value = "type")
    private SystemUserType type;

    @Schema(description = "Phone Number")
    @TableField(value = "phone")
    private String phone;

    @Schema(description = "Avatar URL")
    @TableField(value = "avatar_url")
    private String avatarUrl;

    @Schema(description = "Additional Information")
    @TableField(value = "additional_info")
    private String additionalInfo;

    @Schema(description = "Post ID")
    @TableField(value = "post_id")
    private Long postId;

    @Schema(description = "Account Status")
    @TableField(value = "status")
    private BaseStatus status;


}