package com.nest.renting.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the base status enumeration, which defines common statuses such as enabled and disabled.
 * Implements the {@link BaseEnum} interface, providing code and name for each status.
 */
public enum BaseStatus implements BaseEnum {

    /**
     * Represents the enabled status. The code is 1, and the name is "Normal".
     */
    ENABLE(1, "Normal"),

    /**
     * Represents the disabled status. The code is 0, and the name is "Disable".
     */
    DISABLE(0, "Disable");

    /**
     * The code value of the status, used for database storage and serialization.
     * Annotated with {@link EnumValue} and {@link JsonValue} for MyBatis-Plus and JSON serialization.
     */
    @EnumValue
    @JsonValue
    private Integer code;

    /**
     * The name of the status, used for display purposes.
     */
    private String name;

    /**
     * Constructs a new {@code BaseStatus} instance with the given code and name.
     *
     * @param code the code value of the status
     * @param name the name of the status
     */
    BaseStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Retrieves the code value of the status.
     *
     * @return the code value of the status
     */
    @Override
    public Integer getCode() {
        return this.code;
    }

    /**
     * Retrieves the name of the status.
     *
     * @return the name of the status
     */
    @Override
    public String getName() {
        return this.name;
    }
}
