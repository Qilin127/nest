package com.nest.renting.web.admin.vo.agreement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * AgreementQueryVo is a value object used to encapsulate query parameters for rental agreements.
 * It is designed to be used in API requests to filter and retrieve specific rental agreements.
 * This class uses Lombok's @Data annotation to automatically generate getters, setters,
 * equals, hashCode, and toString methods.
 */
@Data
@Schema(description = "Rental Agreement Query Object")
public class AgreementQueryVo {

    /**
     * The ID of the province where the apartment is located.
     * This field can be used to filter rental agreements by the province of the apartment.
     */
    @Schema(description = "ID of the province where the apartment is located")
    private Long provinceId;

    /**
     * The ID of the city where the apartment is located.
     * This field can be used to filter rental agreements by the city of the apartment.
     */
    @Schema(description = "ID of the city where the apartment is located")
    private Long cityId;

    /**
     * The ID of the district where the apartment is located.
     * This field can be used to filter rental agreements by the district of the apartment.
     */
    @Schema(description = "ID of the district where the apartment is located")
    private Long districtId;

    /**
     * The ID of the apartment.
     * This field can be used to filter rental agreements by a specific apartment.
     */
    @Schema(description = "Apartment ID")
    private Long apartmentId;

    /**
     * The room number of the apartment.
     * This field can be used to filter rental agreements by a specific room in the apartment.
     */
    @Schema(description = "Room number")
    private String roomNumber;

    /**
     * The name of the user associated with the rental agreement.
     * This field can be used to filter rental agreements by the tenant's name.
     */
    @Schema(description = "User name")
    private String name;

    /**
     * The phone number of the user associated with the rental agreement.
     * This field can be used to filter rental agreements by the tenant's phone number.
     */
    @Schema(description = "User phone number")
    private String phone;

}