package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "City Information Table")
@TableName(value = "city_info")
@Data
public class CityInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "City Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Province ID")
    @TableField(value = "province_id")
    private Integer provinceId;

}