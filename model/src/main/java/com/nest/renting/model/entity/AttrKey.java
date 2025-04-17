package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "Room Details Table")
@TableName(value = "attr_key")
@Data
public class AttrKey extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Attribute key")
    @TableField(value = "name")
    private String name;

}