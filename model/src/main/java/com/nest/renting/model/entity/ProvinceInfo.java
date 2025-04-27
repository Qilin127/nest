package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "Province Information Table")
@TableName(value = "province_info")
@Data
public class ProvinceInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Province Name")
    @TableField(value = "name")
    private String name;

}