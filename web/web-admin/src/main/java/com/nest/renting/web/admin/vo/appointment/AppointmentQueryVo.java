package com.nest.renting.web.admin.vo.appointment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents a query object for viewing appointments.
 * This class contains fields used to filter appointment data based on
 * the location of the appointment apartment, the apartment ID,
 * and the information of the user making the appointment.
 */
@Data
@Schema(description = "Viewing Appointment Query Object")
public class AppointmentQueryVo {

    /**
     * The ID of the province where the appointment apartment is located.
     */
    @Schema(description = "Province where the appointment apartment is located")
    private Long provinceId;

    /**
     * The ID of the city where the appointment apartment is located.
     */
    @Schema(description = "City where the appointment apartment is located")
    private Long cityId;

    /**
     * The ID of the district where the appointment apartment is located.
     */
    @Schema(description = "District where the appointment apartment is located")
    private Long districtId;

    /**
     * The ID of the apartment for the appointment.
     */
    @Schema(description = "Apartment ID for the appointment")
    private Long apartmentId;

    /**
     * The name of the user making the appointment.
     */
    @Schema(description = "Name of the user making the appointment")
    private String name;

    /**
     * The phone number of the user making the appointment.
     */
    @Schema(description = "Phone number of the user making the appointment")
    private String phone;

}
