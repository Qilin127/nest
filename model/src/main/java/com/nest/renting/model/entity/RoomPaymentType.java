package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * Represents the association between a room and a payment type.
 * This entity class maps to the "room_payment_type" table in the database.
 * It extends the BaseEntity class, inheriting common fields such as creation and modification timestamps.
 */
@Schema(description = "Room & Payment Type Association Table")
@TableName(value = "room_payment_type")
@Data
// @Builder
public class RoomPaymentType extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     * This field ensures that the same class version is used during serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The ID of the room associated with the payment type.
     */
    @Schema(description = "Room ID")
    @TableField(value = "room_id")
    private Long roomId;

    /**
     * The ID of the payment type associated with the room.
     */
    @Schema(description = "Payment Type ID")
    @TableField(value = "payment_type_id")
    private Long paymentTypeId;


}