package com.nest.renting.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the types of system users. This enum defines different roles of users
 * within the system, each with a unique code and a descriptive name.
 * It implements the {@link BaseEnum} interface, ensuring it provides standard
 * methods for getting the code and name of each enum constant.
 */
public enum SystemUserType implements BaseEnum {

    /**
     * Represents an administrator user. Administrators typically have full access
     * to system features and management capabilities.
     * The code for this user type is 0, and the display name is "Admin".
     */
    ADMIN(0, "Admin"),
    /**
     * Represents a common user. Common users have limited access to system features
     * based on their permissions.
     * The code for this user type is 1, and the display name is "Common User".
     */
    COMMON(1, "Common User");

    /**
     * The unique code associated with each user type.
     * This field is used for database storage and serialization purposes.
     * The {@link EnumValue} annotation indicates it's the value to be stored in the database,
     * and the {@link JsonValue} annotation ensures it's used during JSON serialization.
     */
    @EnumValue
    @JsonValue
    private Integer code;

    /**
     * The descriptive name of each user type.
     * This field is used for display purposes within the application.
     */
    private String name;

    /**
     * Constructs a new SystemUserType enum constant with the specified code and name.
     *
     * @param code the unique code associated with the user type
     * @param name the descriptive name of the user type
     */
    SystemUserType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Retrieves the unique code associated with this user type.
     *
     * @return the code of the user type
     */
    @Override
    public Integer getCode() {
        return this.code;
    }

    /**
     * Retrieves the descriptive name of this user type.
     *
     * @return the name of the user type
     */
    @Override
    public String getName() {
        return this.name;
    }
}
