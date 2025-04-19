package com.nest.renting.web.admin.vo.apartment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Apartment Query Object")
public class ApartmentQueryVo {

    @Schema(description = "Province ID")
    private Long provinceId;

    @Schema(description = "City ID")
    private Long cityId;

    @Schema(description = "District ID")
    private Long districtId;
}
