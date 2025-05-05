package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "District Information Table")
@TableName(value = "district_info")
@Data
public class DistrictInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "District Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "City ID")
    @TableField(value = "city_id")
    private Integer cityId;

}