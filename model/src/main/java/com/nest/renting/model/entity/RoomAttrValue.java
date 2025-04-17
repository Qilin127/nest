package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Room & Attribute Value Association Table")
@TableName(value = "room_attr_value")
@Data
// @Builder
public class RoomAttrValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Room ID")
    @TableField(value = "room_id")
    private Long roomId;

    @Schema(description = "Attribute Value ID")
    @TableField(value = "attr_value_id")
    private Long attrValueId;
}