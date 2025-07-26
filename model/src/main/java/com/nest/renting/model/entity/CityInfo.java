package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Represents the city information entity, corresponding to the `city_info` table in the database.
 * Inherits common fields from the `BaseEntity` class, such as primary key, creation time, update time, and logical deletion flag.
 */
@Schema(description = "City Information Table")
@TableName(value = "city_info")
@Data
public class CityInfo extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The name of the city.
     */
    @Schema(description = "City Name")
    @TableField(value = "name")
    private String name;

    /**
     * The ID of the province where the city is located.
     */
    @Schema(description = "Province ID")
    @TableField(value = "province_id")
    private Integer provinceId;

}