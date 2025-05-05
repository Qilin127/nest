package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "Payment Method Table")
@TableName(value = "payment_type")
@Data
public class PaymentType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Payment Method Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Number of Lease Months per Payment")
    @TableField(value = "pay_month_count")
    private String payMonthCount;

    @Schema(description = "Additional Payment Information")
    @TableField(value = "additional_info")
    private String additionalInfo;


}