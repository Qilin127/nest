package com.nest.renting.web.admin.vo.room;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * RoomQueryVo is a value object used to encapsulate room query parameters.
 * It provides a structured way to pass filter criteria when querying room information.
 * Each field corresponds to a specific filter condition, such as geographical location or apartment ID.
 */
@Schema(description = "Room Query Object")
@Data
public class RoomQueryVo {

    /**
     * Province ID used as a filter when querying rooms.
     * Rooms located within the specified province will be included in the query results.
     */
    @Schema(description = "Province ID")
    private Long provinceId;

    /**
     * City ID used as a filter when querying rooms.
     * Rooms located within the specified city will be included in the query results.
     */
    @Schema(description = "City ID")
    private Long cityId;

    /**
     * District ID used as a filter when querying rooms.
     * Rooms located within the specified district will be included in the query results.
     */
    @Schema(description = "District ID")
    private Long districtId;

    /**
     * Apartment ID used as a filter when querying rooms.
     * Rooms belonging to the specified apartment will be included in the query results.
     */
    @Schema(description = "Apartment ID")
    private Long apartmentId;
}
