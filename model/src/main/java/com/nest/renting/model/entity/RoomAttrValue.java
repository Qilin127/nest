package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * Represents the association between a room and an attribute value.
 * This entity class maps to the "room_attr_value" table in the database.
 * It extends the BaseEntity class, inheriting common fields like creation and update timestamps.
 */
@Schema(description = "Room & Attribute Value Association Table")
@TableName(value = "room_attr_value")
@Data
// @Builder
public class RoomAttrValue extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     * This field ensures that the same class version is used during serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The ID of the room associated with the attribute value.
     */
    @Schema(description = "Room ID")
    @TableField(value = "room_id")
    private Long roomId;

    /**
     * The ID of the attribute value associated with the room.
     */
    @Schema(description = "Attribute Value ID")
    @TableField(value = "attr_value_id")
    private Long attrValueId;
}