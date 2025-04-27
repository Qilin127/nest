package com.nest.renting.model.entity;

import com.nest.renting.model.enums.ReleaseStatus;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Apartment Information Table")
@TableName(value = "apartment_info")
@Data
public class ApartmentInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Apartment Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Apartment Introduction")
    @TableField(value = "introduction")
    private String introduction;

    @Schema(description = "District ID")
    @TableField(value = "district_id")
    private Long districtId;

    @Schema(description = "District Name")
    @TableField(value = "district_name")
    private String districtName;

    @Schema(description = "City ID")
    @TableField(value = "city_id")
    private Long cityId;

    @Schema(description = "City Name")
    @TableField(value = "city_name")
    private String cityName;

    @Schema(description = "Province ID")
    @TableField(value = "province_id")
    private Long provinceId;

    @Schema(description = "Province Name")
    @TableField(value = "province_name")
    private String provinceName;

    @Schema(description = "Detailed Address")
    @TableField(value = "address_detail")
    private String addressDetail;

    @Schema(description = "Latitude")
    @TableField(value = "latitude")
    private String latitude;

    @Schema(description = "Longitude")
    @TableField(value = "longitude")
    private String longitude;

    @Schema(description = "Front Desk Phone Number")
    @TableField(value = "phone")
    private String phone;

    @Schema(description = "Release Status")
    @TableField(value = "is_release")
    private ReleaseStatus isRelease;

}