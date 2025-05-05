package com.nest.renting.web.admin.vo.room;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Room Query Object")
@Data
public class RoomQueryVo {

    @Schema(description = "Province ID")
    private Long provinceId;

    @Schema(description = "City ID")
    private Long cityId;

    @Schema(description = "District ID")
    private Long districtId;

    @Schema(description = "Apartment ID")
    private Long apartmentId;
}
