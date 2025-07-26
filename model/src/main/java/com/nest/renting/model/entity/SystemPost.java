package com.nest.renting.model.entity;

import com.nest.renting.model.enums.BaseStatus;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents the position/post information in the system.
 * This entity class maps to the "system_post" table in the database.
 */
@TableName(value = "system_post")
@Data
public class SystemPost extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The unique code representing the position/post.
     */
    @Schema(description = "Post Code")
    @TableField(value = "code")
    private String postCode;

    /**
     * The name of the position/post.
     */
    @Schema(description = "Post Name")
    @TableField(value = "name")
    private String name;

    /**
     * The description of the position/post.
     */
    @Schema(description = "Post Description")
    @TableField(value = "description")
    private String description;

    /**
     * The status of the position/post, using the BaseStatus enumeration.
     */
    @Schema(description = "Post Status")
    @TableField(value = "status")
    private BaseStatus status;


}