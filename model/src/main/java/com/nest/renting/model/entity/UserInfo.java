package com.nest.renting.model.entity;

import com.nest.renting.model.enums.BaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * Represents the user information entity. This class maps to the "user_info" table in the database.
 * It extends the BaseEntity class, inheriting common fields such as creation and modification timestamps.
 */
@Schema(description = "User Information Table")
@TableName(value = "user_info")
@Data
public class UserInfo extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     * This field ensures that the same class version is used during serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The user's phone number, which is used as the login username.
     */
    @Schema(description = "Phone Number (Used as Login Username)")
    @TableField(value = "phone")
    private String phone;

    /**
     * The user's password. The 'select = false' attribute ensures that this field
     * is not retrieved by default in SQL queries, enhancing security by preventing
     * the password from being returned to the frontend.
     */
    @Schema(description = "Password")
    @TableField(value = "password", select = false) // Do not return password to frontend (for security)
    private String password;

    /**
     * The URL of the user's avatar image.
     */
    @Schema(description = "Avatar URL")
    @TableField(value = "avatar_url")
    private String avatarUrl;

    /**
     * The user's nickname.
     */
    @Schema(description = "Nickname")
    @TableField(value = "nickname")
    private String nickname;

    /**
     * The status of the user's account. The status is defined by the BaseStatus enumeration.
     */
    @Schema(description = "Account Status")
    @TableField(value = "status")
    private BaseStatus status;



}