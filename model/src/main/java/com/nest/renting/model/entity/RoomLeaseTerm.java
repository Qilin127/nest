package com.nest.renting.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the association between a room and a lease term.
 * This entity class maps to the "room_lease_term" table in the database.
 * It extends the BaseEntity class, inheriting common fields such as creation and update timestamps.
 */
@TableName(value = "room_lease_term")
@Data
@Schema(description = "Room & Lease Term Association Table")
// @Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomLeaseTerm extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     * This field ensures that the same class version is used during serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The ID of the room associated with the lease term.
     */
    @Schema(description = "Room ID")
    @TableField("room_id")
    private Long roomId;

    /**
     * The ID of the lease term associated with the room.
     */
    @Schema(description = "Lease Term ID")
    @TableField("lease_term_id")
    private Long leaseTermId;

}