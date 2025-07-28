package com.nest.renting.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents the relationship between an apartment and its facilities.
 * This entity class maps to the "apartment_facility" table in the database.
 * It extends the BaseEntity class, inheriting common entity properties.
 */
@Schema(description = "Apartment & Facility Relationship")
@TableName(value = "apartment_facility")
@Data
//@Builder
public class ApartmentFacility extends BaseEntity {

    /**
     * Serial version UID for the class, used for serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier of the apartment.
     */
    @Schema(description = "Apartment id")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    /**
     * The unique identifier of the facility.
     */
    @Schema(description = "Facility id")
    @TableField(value = "facility_id")
    private Long facilityId;


}