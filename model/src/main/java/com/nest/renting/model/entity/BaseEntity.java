package com.nest.renting.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    @Schema(description = "Primary Key")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "Creation Time")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonIgnore
    private Date createTime;

    @Schema(description = "Last Update Time")
    @TableField(value = "update_time", fill = FieldFill.UPDATE) // Insert time when updating
    @JsonIgnore
    private Date updateTime;

    @Schema(description = "Logical Deletion Flag")
    @TableField("is_deleted")
    @TableLogic // Use default logical deletion
    @JsonIgnore // Do not return this to frontend
    private Byte isDeleted;

}