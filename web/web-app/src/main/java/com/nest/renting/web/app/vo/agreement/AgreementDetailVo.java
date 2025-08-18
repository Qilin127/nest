package com.nest.renting.web.app.vo.agreement;

import com.nest.renting.model.entity.LeaseAgreement;
import com.nest.renting.web.app.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * AgreementDetailVo represents detailed information about a lease agreement, 
 * including apartment and room details, images, payment method, and lease terms.
 */

@Data
@Schema(description = "Lease Agreement Details")
public class AgreementDetailVo extends LeaseAgreement {

    @Schema(description = "Apartment Name")
    private String apartmentName;

    @Schema(description = "Apartment Image List")
    private List<GraphVo> apartmentGraphVoList;

    @Schema(description = "Room Number")
    private String roomNumber;

    @Schema(description = "Room Image List")
    private List<GraphVo> roomGraphVoList;

    @Schema(description = "Payment Method")
    private String paymentTypeName;

    @Schema(description = "Lease Term in Months")
    private Integer leaseTermMonthCount;

    @Schema(description = "Lease Term Unit")
    private String leaseTermUnit;

}