package com.nest.renting.web.app.vo.agreement;

import com.nest.renting.model.enums.LeaseSourceType;
import com.nest.renting.model.enums.LeaseStatus;
import com.nest.renting.web.app.vo.graph.GraphVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * AgreementItemVo represents basic information about a lease agreement, 
 * including room and apartment details, lease status, dates, source, and rent.
 */

@Data
@Schema(description = "Lease Basic Information")
public class AgreementItemVo {

    @Schema(description = "Lease ID")
    private Long id;

    @Schema(description = "Room Image List")
    private List<GraphVo> roomGraphVoList;

    @Schema(description = "Apartment Name")
    private String apartmentName;

    @Schema(description = "Room Number")
    private String roomNumber;

    @Schema(description = "Lease Status")
    private LeaseStatus leaseStatus;

    @Schema(description = "Lease Start Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date leaseStartDate;

    @Schema(description = "Lease End Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date leaseEndDate;

    @Schema(description = "Lease Source")
    private LeaseSourceType sourceType;

    @Schema(description = "Rent")
    private BigDecimal rent;
    
}
