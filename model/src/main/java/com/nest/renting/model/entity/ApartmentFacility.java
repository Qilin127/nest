package com.nest.renting.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Apartment & Facility Relationship")
@TableName(value = "apartment_facility")
@Data
//@Builder
public class ApartmentFacility extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Apartment id")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "Facility id")
    @TableField(value = "facility_id")
    private Long facilityId;


}