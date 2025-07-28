package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * Represents the association between a room and a facility.
 * This entity class maps to the "room_facility" table in the database.
 * It extends the BaseEntity class, inheriting common fields such as creation and modification timestamps.
 */
@Schema(description = "Room & Facility Association Table")
@TableName(value = "room_facility")
@Data
// @Builder
public class RoomFacility extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     * This field ensures that the same class version is used during serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The ID of the room associated with the facility.
     */
    @Schema(description = "Room ID")
    @TableField(value = "room_id")
    private Long roomId;

    /**
     * The ID of the facility associated with the room.
     */
    @Schema(description = "Facility ID")
    @TableField(value = "facility_id")
    private Long facilityId;

}