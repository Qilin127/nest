package com.nest.renting.web.app.vo.appointment;

import com.nest.renting.model.entity.ViewAppointment;
import com.nest.renting.web.app.vo.apartment.ApartmentItemVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * AppointmentDetailVo represents detailed information about a viewing appointment, 
 * including associated apartment details.
 */
@Data
@Schema(description = "Appointment Viewing Details for APP")
public class AppointmentDetailVo extends ViewAppointment {

    @Schema(description = "Apartment Basic Information")
    private ApartmentItemVo apartmentItemVo;
}
