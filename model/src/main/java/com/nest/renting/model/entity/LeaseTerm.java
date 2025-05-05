package com.nest.renting.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @TableName lease_term
 */
@TableName(value = "lease_term")
@Data
@Schema(description = "Lease Term Information")
public class LeaseTerm extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Number of Lease Months")
    @TableField("month_count")
    private Integer monthCount;

    @Schema(description = "Lease Term Unit : Month")
    @TableField("unit")
    private String unit;
}