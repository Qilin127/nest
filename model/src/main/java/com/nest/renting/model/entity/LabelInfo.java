package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.nest.renting.model.enums.ItemType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "Label Information Table")
@TableName(value = "label_info")
@Data
public class LabelInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Associated Object Type")
    @TableField(value = "type")
    private ItemType type;

    @Schema(description = "Label Name")
    @TableField(value = "name")
    private String name;


}