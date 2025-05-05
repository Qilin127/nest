package com.nest.renting.web.admin.vo.agreement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Rental Agreement Query Object")
public class AgreementQueryVo {

    @Schema(description = "ID of the province where the apartment is located")
    private Long provinceId;

    @Schema(description = "ID of the city where the apartment is located")
    private Long cityId;

    @Schema(description = "ID of the district where the apartment is located")
    private Long districtId;

    @Schema(description = "Apartment ID")
    private Long apartmentId;

    @Schema(description = "Room number")
    private String roomNumber;

    @Schema(description = "User name")
    private String name;

    @Schema(description = "User phone number")
    private String phone;

}