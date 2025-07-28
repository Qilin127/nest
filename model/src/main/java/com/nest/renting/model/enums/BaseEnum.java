package com.nest.renting.model.enums;

/**
 * Defines a common interface for enumeration classes.
 * This interface provides two methods to standardize the way
 * enums represent their code and name, which can be used for
 * data serialization, database storage, and UI display.
 */
public interface BaseEnum {

    /**
     * Retrieves the code associated with the enum constant.
     * The code is typically an integer value used to uniquely
     * identify the enum constant, often for database storage
     * or data transmission purposes.
     *
     * @return The integer code of the enum constant.
     */
    Integer getCode();

    /**
     * Retrieves the name associated with the enum constant.
     * The name is a human-readable string that can be used
     * for UI display or logging purposes.
     *
     * @return The human-readable name of the enum constant.
     */
    String getName();
}
