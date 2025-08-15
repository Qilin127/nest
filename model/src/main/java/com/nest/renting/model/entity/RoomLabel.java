package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * Represents the association between a room and a label.
 * This entity class corresponds to the "room_label" table in the database.
 * It extends the BaseEntity class, inheriting common fields such as creation time and update time.
 */
@Schema(description = "Room & Label Association Table")
@TableName(value = "room_label")
@Data
// @Builder
public class RoomLabel extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     * This field ensures that the same class version is used during serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The ID of the room associated with the label.
     */
    @Schema(description = "Room ID")
    @TableField(value = "room_id")
    private Long roomId;

    /**
     * The ID of the label associated with the room.
     */
    @Schema(description = "Label ID")
    @TableField(value = "label_id")
    private Long labelId;

}