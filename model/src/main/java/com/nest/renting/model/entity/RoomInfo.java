package com.nest.renting.model.entity;

import com.nest.renting.model.enums.ReleaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Represents the room information. This entity class maps to the "room_info" table in the database.
 * It extends the BaseEntity class, inheriting common fields such as creation and modification timestamps.
 */
@Schema(description = "Room Information Table")
@TableName(value = "room_info")
@Data
public class RoomInfo extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     * This field ensures that the same class version is used during serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier for the room, typically a room number.
     */
    @Schema(description = "Room Number")
    @TableField(value = "room_number")
    private String roomNumber;

    /**
     * The monthly rent for the room, measured in dollars.
     */
    @Schema(description = "Rent (Dollar/Month)")
    @TableField(value = "rent")
    private BigDecimal rent;

    /**
     * The ID of the apartment associated with this room.
     */
    @Schema(description = "Associated Apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    /**
     * The release status of the room, represented by the ReleaseStatus enumeration.
     */
    @Schema(description = "Release Status")
    @TableField(value = "is_release")
    private ReleaseStatus isRelease;

}