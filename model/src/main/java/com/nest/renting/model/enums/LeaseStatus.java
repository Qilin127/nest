package com.nest.renting.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the status of a lease agreement. This enum defines various states
 * that a lease can be in, along with their corresponding codes and names.
 * It implements the {@link BaseEnum} interface, providing standard methods
 * to retrieve the code and name of each enum value.
 */
public enum LeaseStatus implements BaseEnum {

    /**
     * The lease is in the signing process and awaiting confirmation.
     */
    SIGNING(1, "Signing Pending Confirmation"),
    /**
     * The lease has been successfully signed.
     */
    SIGNED(2, "Signed"),
    /**
     * The lease has been canceled.
     */
    CANCELED(3, "Canceled"),
    /**
     * The lease has expired.
     */
    EXPIRED(4, "Expired"),
    /**
     * The lease is in the withdrawal process and awaiting confirmation.
     */
    WITHDRAWING(5, "Withdrawal Pending Confirmation"),
    /**
     * The lease has been withdrawn.
     */
    WITHDRAWN(6, "Withdrawn"),
    /**
     * The lease is in the renewal process and awaiting confirmation.
     */
    RENEWING(7, "Renewal Pending Confirmation");

    /**
     * The unique code associated with the lease status.
     * This value is used for database mapping and JSON serialization.
     */
    @EnumValue
    @JsonValue
    private Integer code;

    /**
     * The human-readable name of the lease status.
     */
    private String name;

    /**
     * Constructs a new LeaseStatus enum instance.
     *
     * @param code the unique code for the lease status
     * @param name the human-readable name of the lease status
     */
    LeaseStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Retrieves the unique code associated with the lease status.
     *
     * @return the code of the lease status
     */
    @Override
    public Integer getCode() {
        return this.code;
    }

    /**
     * Retrieves the human-readable name of the lease status.
     *
     * @return the name of the lease status
     */
    @Override
    public String getName() {
        return this.name;
    }

}