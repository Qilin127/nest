package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Represents the miscellaneous fee value table in the database.
 * This entity class maps to the "fee_value" table and inherits from BaseEntity.
 */
@Schema(description = "Miscellaneous Fee Value Table")
@TableName(value = "fee_value")
@Data
public class FeeValue extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The value of the fee.
     */
    @Schema(description = "Fee Value")
    @TableField(value = "name")
    private String name;

    /**
     * The charging unit of the fee.
     */
    @Schema(description = "Charging Unit")
    @TableField(value = "unit")
    private String unit;

    /**
     * The ID of the associated fee key.
     */
    @Schema(description = "Associated Fee Key ID")
    @TableField(value = "fee_key_id")
    private Long feeKeyId;

}