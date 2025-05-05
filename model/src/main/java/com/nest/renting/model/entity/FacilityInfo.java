package com.nest.renting.model.entity;

import com.nest.renting.model.enums.ItemType;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "Facility Information Table")
@TableName(value = "facility_info")
@Data
public class FacilityInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema(description = "Type of Associated Object")
    @TableField(value = "type")
    private ItemType type;

    @Schema(description = "Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Icon")
    @TableField(value = "icon")
    private String icon;

}