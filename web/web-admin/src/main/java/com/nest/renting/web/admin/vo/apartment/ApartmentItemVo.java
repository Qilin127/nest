package com.nest.renting.web.admin.vo.apartment;

import com.nest.renting.model.entity.ApartmentInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "Apartment List Item for Admin System")
public class ApartmentItemVo extends ApartmentInfo {

    @Schema(description = "Total number of rooms")
    private Long totalRoomCount;

    @Schema(description = "Number of available rooms")
    private Long freeRoomCount;

}
