package com.nest.renting.model.entity;

import com.nest.renting.model.enums.BaseStatus;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Position/Post Information Table
 *
 * @TableName system_post
 */
@TableName(value = "system_post")
@Data
public class SystemPost extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Post Code")
    @TableField(value = "code")
    private String postCode;

    @Schema(description = "Post Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Post Description")
    @TableField(value = "description")
    private String description;

    @Schema(description = "Post Status")
    @TableField(value = "status")
    private BaseStatus status;


}