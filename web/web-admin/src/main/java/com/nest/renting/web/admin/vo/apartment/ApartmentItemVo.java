package com.nest.renting.web.admin.vo.apartment;

import com.nest.renting.model.entity.ApartmentInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents an item in the apartment list for the admin system.
 * This class extends {@link ApartmentInfo} and includes additional information
 * about the total number of rooms and the number of available rooms in the apartment.
 */
@Data
@Schema(description = "Apartment List Item for Admin System")
public class ApartmentItemVo extends ApartmentInfo {

    /**
     * The total number of rooms in the apartment.
     */
    @Schema(description = "Total number of rooms")
    private Long totalRoomCount;

    /**
     * The number of available rooms in the apartment.
     */
    @Schema(description = "Number of available rooms")
    private Long freeRoomCount;

}
