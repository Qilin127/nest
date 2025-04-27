package com.nest.renting.web.admin.vo.appointment;

import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.model.entity.ViewAppointment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Viewing Appointment Information")
public class AppointmentVo extends ViewAppointment {

    @Schema(description = "Information about the apartment being viewed")
    private ApartmentInfo apartmentInfo;

}
