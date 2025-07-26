package com.nest.renting.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the status of a viewing appointment. This enum defines various statuses
 * that an appointment can have, along with their corresponding codes and names.
 * It implements the {@link BaseEnum} interface, ensuring it provides standard methods
 * for getting the code and name of each enum value.
 */
public enum AppointmentStatus implements BaseEnum {

    /**
     * Indicates that the appointment is waiting for the viewing to take place.
     * The associated code is 1, and the display name is "Waiting for viewing".
     */
    WAITING(1, "Waiting for viewing"),

    /**
     * Indicates that the appointment has been cancelled.
     * The associated code is 2, and the display name is "Cancelled".
     */
    CANCELED(2, "Cancelled"),

    /**
     * Indicates that the viewing has already taken place.
     * The associated code is 3, and the display name is "Already viewed".
     */
    VIEWED(3, "Already viewed");

    /**
     * The code associated with the appointment status. This value is used for database
     * storage and serialization. Annotated with {@link EnumValue} for MyBatis-Plus
     * integration and {@link JsonValue} for JSON serialization.
     */
    @EnumValue
    @JsonValue
    private Integer code;

    /**
     * The human-readable name of the appointment status. This value is used for display
     * purposes.
     */
    private String name;

    /**
     * Constructs a new {@code AppointmentStatus} enum value with the specified code and name.
     *
     * @param code the code associated with the appointment status
     * @param name the human-readable name of the appointment status
     */
    AppointmentStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Retrieves the code associated with this appointment status.
     *
     * @return the code of this appointment status
     */
    @Override
    public Integer getCode() {
        return this.code;
    }

    /**
     * Retrieves the human-readable name of this appointment status.
     *
     * @return the name of this appointment status
     */
    @Override
    public String getName() {
        return this.name;
    }
}
