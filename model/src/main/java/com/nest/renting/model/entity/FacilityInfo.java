package com.nest.renting.model.entity;

import com.nest.renting.model.enums.ItemType;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Represents the Facility Information Table in the database.
 * This class extends the {@link BaseEntity} class, inheriting common fields such as
 * primary key, creation time, last update time, and logical deletion flag.
 */
@Schema(description = "Facility Information Table")
@TableName(value = "facility_info")
@Data
public class FacilityInfo extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The type of the associated object.
     */
    @Schema(description = "Type of Associated Object")
    @TableField(value = "type")
    private ItemType type;

    /**
     * The name of the facility.
     */
    @Schema(description = "Name")
    @TableField(value = "name")
    private String name;

    /**
     * The icon associated with the facility.
     */
    @Schema(description = "Icon")
    @TableField(value = "icon")
    private String icon;

}