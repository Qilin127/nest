package com.nest.renting.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the release status of an entity. This enum provides two possible states: released and not released.
 * It implements the {@link BaseEnum} interface, ensuring it provides a code and a name for each status.
 */
public enum ReleaseStatus implements BaseEnum {

    /**
     * Indicates that the entity has been released.
     * The code associated with this status is 1, and the display name is "Released".
     */
    RELEASED(1, "Released"),
    /**
     * Indicates that the entity has not been released.
     * The code associated with this status is 0, and the display name is "Not Released".
     */
    NOT_RELEASED(0, "Not Released");

    /**
     * The code value of the release status, used for database storage and serialization.
     * Annotated with {@link EnumValue} for MyBatis-Plus integration and {@link JsonValue} for JSON serialization.
     */
    @EnumValue
    @JsonValue
    private Integer code;

    /**
     * The human-readable name of the release status, used for display purposes.
     */
    private String name;

    /**
     * Constructs a new ReleaseStatus enum instance.
     *
     * @param code the code value of the release status
     * @param name the human-readable name of the release status
     */
    ReleaseStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Retrieves the code value of the release status.
     *
     * @return the code value of the release status
     */
    @Override
    public Integer getCode() {
        return this.code;
    }

    /**
     * Retrieves the human-readable name of the release status.
     *
     * @return the human-readable name of the release status
     */
    @Override
    public String getName() {
        return this.name;
    }

}
