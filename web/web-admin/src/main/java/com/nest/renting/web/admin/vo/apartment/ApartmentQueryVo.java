package com.nest.renting.web.admin.vo.apartment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * The number of available rooms in the apartment.
 */
@Data
@Schema(description = "Apartment Query Object")
public class ApartmentQueryVo {

    /**
     * The ID of the province where the apartment is located.
     * This field can be used as a filter criterion when querying apartments.
     */
    @Schema(description = "Province ID")
    private Long provinceId;

    /**
     * The ID of the city where the apartment is located.
     * This field can be used in conjunction with the province ID to narrow down the search for apartments.
     */
    @Schema(description = "City ID")
    private Long cityId;

    /**
     * The ID of the district where the apartment is located.
     * This field can be used along with the province and city IDs for more precise apartment queries.
     */
    @Schema(description = "District ID")
    private Long districtId;
}
