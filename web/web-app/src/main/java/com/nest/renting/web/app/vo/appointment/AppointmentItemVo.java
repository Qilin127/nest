package com.nest.renting.web.app.vo.appointment;

import com.nest.renting.model.enums.AppointmentStatus;
import com.nest.renting.web.app.vo.graph.GraphVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * AppointmentItemVo represents basic information about a viewing appointment, 
 * including apartment details, images, appointment time, and status.
 */
@Data
@Schema(description = "Basic Information for Viewing Appointments in APP")
public class AppointmentItemVo {

    @Schema(description = "Appointment ID")
    private Long id;

    @Schema(description = "Apartment Name for Appointment")
    private String apartmentName;

    @Schema(description = "Apartment Image List")
    private List<GraphVo> graphVoList;

    @Schema(description = "Appointment Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date appointmentTime;

    @Schema(description = "Current Appointment Status")
    private AppointmentStatus appointmentStatus;
}
