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

@Schema(description = "Lease Agreement Table")
@TableName(value = "lease_agreement")
@Data
public class LeaseAgreement extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Tenant's Phone Number")
    @TableField(value = "phone")
    private String phone;

    @Schema(description = "Tenant's Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Tenant's Identification Number")
    @TableField(value = "identification_number")
    private String identificationNumber;

    @Schema(description = "Signed Apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "Signed Room ID")
    @TableField(value = "room_id")
    private Long roomId;

    @Schema(description = "Lease Start Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "lease_start_date")
    private Date leaseStartDate;

    @Schema(description = "Lease End Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "lease_end_date")
    private Date leaseEndDate;

    @Schema(description = "Lease Term ID")
    @TableField(value = "lease_term_id")
    private Long leaseTermId;

    @Schema(description = "Rent (CNY/Month)")
    @TableField(value = "rent")
    private BigDecimal rent;

    @Schema(description = "Deposit (CNY)")
    @TableField(value = "deposit")
    private BigDecimal deposit;

    @Schema(description = "Payment Type ID")
    @TableField(value = "payment_type_id")
    private Long paymentTypeId;

    @Schema(description = "Lease Status")
    @TableField(value = "status")
    private LeaseStatus status;

    @Schema(description = "Lease Source")
    @TableField(value = "source_type")
    private LeaseSourceType sourceType;

    @Schema(description = "Additional Information")
    @TableField(value = "additional_info")
    private String additionalInfo;
}