package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Represents the payment method information. This entity class maps to the "payment_type" table in the database.
 * It extends the BaseEntity class, inheriting common fields such as creation and modification timestamps.
 */
@Schema(description = "Payment Method Table")
@TableName(value = "payment_type")
@Data
public class PaymentType extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     * This field is used to ensure that the same class version is used during serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The name of the payment method.
     */
    @Schema(description = "Payment Method Name")
    @TableField(value = "name")
    private String name;

    /**
     * The number of lease months per payment.
     */
    @Schema(description = "Number of Lease Months per Payment")
    @TableField(value = "pay_month_count")
    private String payMonthCount;

    /**
     * Additional information related to the payment method.
     */
    @Schema(description = "Additional Payment Information")
    @TableField(value = "additional_info")
    private String additionalInfo;


}