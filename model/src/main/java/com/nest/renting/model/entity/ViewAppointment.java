package com.nest.renting.model.entity;

import com.nest.renting.model.enums.AppointmentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Represents the viewing appointment information. This entity class maps to the "view_appointment" table in the database.
 * It extends the BaseEntity class, inheriting common fields such as creation and modification timestamps.
 */
@Schema(description = "Viewing Appointment Information Table")
@TableName(value = "view_appointment")
@Data
public class ViewAppointment extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     * This field ensures that the same class version is used during serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The ID of the user who made the viewing appointment.
     */
    @Schema(description = "User ID")
    @TableField(value = "user_id")
    private Long userId;

    /**
     * The name of the user who made the viewing appointment.
     */
    @Schema(description = "User Name")
    @TableField(value = "name")
    private String name;

    /**
     * The phone number of the user who made the viewing appointment.
     */
    @Schema(description = "User Phone Number")
    @TableField(value = "phone")
    private String phone;

    /**
     * The ID of the apartment for which the viewing appointment was made.
     */
    @Schema(description = "Apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    /**
     * The time scheduled for the viewing appointment.
     */
    @Schema(description = "Appointment Time")
    @TableField(value = "appointment_time")
    private Date appointmentTime;

    /**
     * Any additional information provided by the user regarding the viewing appointment.
     */
    @Schema(description = "Additional Information")
    @TableField(value = "additional_info")
    private String additionalInfo;

    /**
     * The status of the viewing appointment, defined by the AppointmentStatus enumeration.
     */
    @Schema(description = "Appointment Status")
    @TableField(value = "appointment_status")
    private AppointmentStatus appointmentStatus;
}