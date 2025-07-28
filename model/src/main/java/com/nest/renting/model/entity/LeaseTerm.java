package com.nest.renting.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents the lease term information. This entity class maps to the "lease_term" table in the database.
 * It extends the BaseEntity class, inheriting common fields such as creation and modification timestamps.
 */
@TableName(value = "lease_term")
@Data
@Schema(description = "Lease Term Information")
public class LeaseTerm extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The number of months in the lease term.
     */
    @Schema(description = "Number of Lease Months")
    @TableField("month_count")
    private Integer monthCount;

    /**
     * The unit of the lease term, typically "Month".
     */
    @Schema(description = "Lease Term Unit : Month")
    @TableField("unit")
    private String unit;
}