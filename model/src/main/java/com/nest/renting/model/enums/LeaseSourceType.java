package com.nest.renting.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration representing the source types of a lease.
 * This enum provides two types of lease sources: new signature and renewal.
 * It implements the {@link BaseEnum} interface, providing standard methods to get the code and name.
 */
public enum LeaseSourceType implements BaseEnum {

    /**
     * Represents a new lease signature.
     * The code for this type is 1, and the name is "New Signature".
     */
    NEW(1, "New Signature"),

    /**
     * Represents a lease renewal.
     * The code for this type is 2, and the name is "Renewal".
     */
    RENEW(2, "Renewal");

    /**
     * The unique code associated with the lease source type.
     * This code is used for database storage and serialization.
     */
    @JsonValue
    @EnumValue
    private Integer code;

    /**
     * The descriptive name of the lease source type.
     * This name is used for display purposes.
     */
    private String name;

    /**
     * Constructs a new {@code LeaseSourceType} with the specified code and name.
     *
     * @param code the unique code of the lease source type
     * @param name the descriptive name of the lease source type
     */
    LeaseSourceType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Retrieves the unique code of the lease source type.
     *
     * @return the code of the lease source type
     */
    @Override
    public Integer getCode() {
        return this.code;
    }

    /**
     * Retrieves the descriptive name of the lease source type.
     *
     * @return the name of the lease source type
     */
    @Override
    public String getName() {
        return this.name;
    }
}
