package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.nest.renting.model.enums.LeaseSourceType;
import com.nest.renting.model.enums.LeaseStatus;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents the Lease Agreement Table in the database.
 * This entity class stores information about lease agreements,
 * including tenant details, leased property information, and lease terms.
 */
@Schema(description = "Lease Agreement Table")
@TableName(value = "lease_agreement")
@Data
public class LeaseAgreement extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The phone number of the tenant.
     */
    @Schema(description = "Tenant's Phone Number")
    @TableField(value = "phone")
    private String phone;

    /**
     * The name of the tenant.
     * This field stores the full name of the tenant who signed the lease agreement.
     */
    @Schema(description = "Tenant's Name")
    @TableField(value = "name")
    private String name;

    /**
     * The identification number of the tenant.
     * This field stores the unique identification number of the tenant, such as an ID card number.
     */
    @Schema(description = "Tenant's Identification Number")
    @TableField(value = "identification_number")
    private String identificationNumber;

    /**
     * The ID of the apartment that the tenant signed the lease for.
     * This field links the lease agreement to the specific apartment.
     */
    @Schema(description = "Signed Apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    /**
     * The ID of the room that the tenant signed the lease for.
     * This field links the lease agreement to the specific room within the apartment.
     */
    @Schema(description = "Signed Room ID")
    @TableField(value = "room_id")
    private Long roomId;

    /**
     * The start date of the lease.
     * This field stores the date when the lease agreement comes into effect.
     */
    @Schema(description = "Lease Start Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "lease_start_date")
    private Date leaseStartDate;

    /**
     * The end date of the lease.
     * This field stores the date when the lease agreement expires.
     */
    @Schema(description = "Lease End Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "lease_end_date")
    private Date leaseEndDate;

    /**
     * The ID of the lease term.
     * This field links the lease agreement to the specific lease term configuration.
     */
    @Schema(description = "Lease Term ID")
    @TableField(value = "lease_term_id")
    private Long leaseTermId;

    /**
     * The rent amount in Chinese Yuan per month.
     * This field stores the monthly rent that the tenant needs to pay.
     */
    @Schema(description = "Rent (CNY/Month)")
    @TableField(value = "rent")
    private BigDecimal rent;

    /**
     * The deposit amount in Chinese Yuan.
     * This field stores the deposit that the tenant needs to pay as a guarantee.
     */
    @Schema(description = "Deposit (CNY)")
    @TableField(value = "deposit")
    private BigDecimal deposit;

    /**
     * The ID of the payment type.
     * This field links the lease agreement to the specific payment type configuration.
     */
    @Schema(description = "Payment Type ID")
    @TableField(value = "payment_type_id")
    private Long paymentTypeId;

    /**
     * The status of the lease.
     * This field indicates the current status of the lease agreement, such as active, expired, etc.
     */
    @Schema(description = "Lease Status")
    @TableField(value = "status")
    private LeaseStatus status;

    /**
     * The source of the lease.
     * This field indicates where the lease agreement originated from, such as online platform, offline agency, etc.
     */
    @Schema(description = "Lease Source")
    @TableField(value = "source_type")
    private LeaseSourceType sourceType;

    /**
     * Additional information about the lease agreement.
     * This field can be used to store any extra details related to the lease agreement.
     */
    @Schema(description = "Additional Information")
    @TableField(value = "additional_info")
    private String additionalInfo;
}