package com.nest.renting.web.app.vo.room;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * RoomQueryVo represents the query parameters for searching rooms, including location, rent range, 
 * payment method, and sorting options.
 */
@Data
@Schema(description = "Room Query Entity")
public class RoomQueryVo {

    @Schema(description = "Province ID")
    private Long provinceId;

    @Schema(description = "City ID")
    private Long cityId;

    @Schema(description = "District ID")
    private Long districtId;

    @Schema(description = "Minimum Rent")
    private BigDecimal minRent;

    @Schema(description = "Maximum Rent")
    private BigDecimal maxRent;

    @Schema(description = "Payment Method ID")
    private Long paymentTypeId;

    @Schema(description = "Price Sorting Order", allowableValues = {"desc", "asc"})
    private String orderType;

}
