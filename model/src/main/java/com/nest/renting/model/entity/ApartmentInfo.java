package com.nest.renting.model.entity;

import com.nest.renting.model.enums.ReleaseStatus;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents the Apartment Information Table in the database.
 * This class stores various details about an apartment, such as its name,
 * introduction, location information, and release status.
 * It extends the BaseEntity class, inheriting common entity fields.
 */
@Schema(description = "Apartment Information Table")
@TableName(value = "apartment_info")
@Data
public class ApartmentInfo extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The name of the apartment.
     */
    @Schema(description = "Apartment Name")
    @TableField(value = "name")
    private String name;

    /**
     * A brief introduction of the apartment.
     */
    @Schema(description = "Apartment Introduction")
    @TableField(value = "introduction")
    private String introduction;

    /**
     * The ID of the district where the apartment is located.
     */
    @Schema(description = "District ID")
    @TableField(value = "district_id")
    private Long districtId;

    /**
     * The name of the district where the apartment is located.
     */
    @Schema(description = "District Name")
    @TableField(value = "district_name")
    private String districtName;

    /**
     * The ID of the city where the apartment is located.
     */
    @Schema(description = "City ID")
    @TableField(value = "city_id")
    private Long cityId;

    /**
     * The name of the city where the apartment is located.
     */
    @Schema(description = "City Name")
    @TableField(value = "city_name")
    private String cityName;

    /**
     * The ID of the province where the apartment is located.
     */
    @Schema(description = "Province ID")
    @TableField(value = "province_id")
    private Long provinceId;

    /**
     * The name of the province where the apartment is located.
     */
    @Schema(description = "Province Name")
    @TableField(value = "province_name")
    private String provinceName;

    /**
     * The detailed address of the apartment.
     * This field stores the specific location information of the apartment,
     * such as street name, building number, and unit number.
     */
    @Schema(description = "Detailed Address")
    @TableField(value = "address_detail")
    private String addressDetail;

    /**
     * The latitude of the apartment's location.
     * This field stores the geographical latitude of the apartment,
     * used to identify its position on the Earth's surface.
     */
    @Schema(description = "Latitude")
    @TableField(value = "latitude")
    private String latitude;

    /**
     * The longitude of the apartment's location.
     * This field stores the geographical longitude of the apartment,
     * used in conjunction with latitude to pinpoint its exact location on the Earth.
     */
    @Schema(description = "Longitude")
    @TableField(value = "longitude")
    private String longitude;

    /**
     * The front desk phone number of the apartment.
     * This field stores the contact phone number of the apartment's front desk,
     * which can be used by residents or visitors to get in touch.
     */
    @Schema(description = "Front Desk Phone Number")
    @TableField(value = "phone")
    private String phone;

    /**
     * The release status of the apartment.
     * This field indicates whether the apartment is released and available for rent,
     * using the {@link ReleaseStatus} enumeration to represent different states.
     */
    @Schema(description = "Release Status")
    @TableField(value = "is_release")
    private ReleaseStatus isRelease;

}