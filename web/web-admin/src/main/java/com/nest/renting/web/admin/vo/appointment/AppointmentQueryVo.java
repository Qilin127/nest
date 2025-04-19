package com.nest.renting.web.admin.vo.appointment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Viewing Appointment Query Object")
public class AppointmentQueryVo {

    @Schema(description = "Province where the appointment apartment is located")
    private Long provinceId;

    @Schema(description = "City where the appointment apartment is located")
    private Long cityId;

    @Schema(description = "District where the appointment apartment is located")
    private Long districtId;

    @Schema(description = "Apartment ID for the appointment")
    private Long apartmentId;

    @Schema(description = "Name of the user making the appointment")
    private String name;

    @Schema(description = "Phone number of the user making the appointment")
    private String phone;

}
