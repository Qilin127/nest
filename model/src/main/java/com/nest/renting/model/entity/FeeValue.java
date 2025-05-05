package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "Miscellaneous Fee Value Table")
@TableName(value = "fee_value")
@Data
public class FeeValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Fee Value")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Charging Unit")
    @TableField(value = "unit")
    private String unit;

    @Schema(description = "Associated Fee Key ID")
    @TableField(value = "fee_key_id")
    private Long feeKeyId;

}