package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "Miscellaneous Fee Name Table")
@TableName(value = "fee_key")
@Data
public class FeeKey extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Fee Item Key")
    @TableField(value = "name")
    private String name;


}