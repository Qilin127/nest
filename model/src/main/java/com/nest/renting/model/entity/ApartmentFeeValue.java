package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * Represents the association between apartments and miscellaneous fees.
 * This entity class maps to the `apartment_fee_value` table in the database.
 * It extends the `BaseEntity` class, inheriting common fields and behaviors.
 */
@Schema(description = "Apartment & Miscellaneous Fees Association Table")
@TableName(value = "apartment_fee_value")
@Data
//@Builder
public class ApartmentFeeValue extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier of the apartment.
     */
    @Schema(description = "Apartment id")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    /**
     * The unique identifier of the fee value.
     */
    @Schema(description = "Fee value_id")
    @TableField(value = "fee_value_id")
    private Long feeValueId;

}