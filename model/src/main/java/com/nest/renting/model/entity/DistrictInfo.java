package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Represents the district information entity, which maps to the 'district_info' table in the database.
 * This class extends the BaseEntity class, inheriting common fields such as primary key, creation time,
 * last update time, and logical deletion flag.
 */
@Schema(description = "District Information Table")
@TableName(value = "district_info")
@Data
public class DistrictInfo extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The name of the district.
     */
    @Schema(description = "District Name")
    @TableField(value = "name")
    private String name;

    /**
     * The ID of the city to which the district belongs.
     */
    @Schema(description = "City ID")
    @TableField(value = "city_id")
    private Integer cityId;

}