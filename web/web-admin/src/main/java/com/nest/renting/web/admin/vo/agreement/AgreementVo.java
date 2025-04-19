package com.nest.renting.web.admin.vo.agreement;

import com.nest.renting.model.entity.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Lease Agreement Information")
public class AgreementVo extends LeaseAgreement {

    @Schema(description = "Signed apartment information")
    private ApartmentInfo apartmentInfo;

    @Schema(description = "Signed room information")
    private RoomInfo roomInfo;

    @Schema(description = "Payment method")
    private PaymentType paymentType;

    @Schema(description = "Lease term")
    private LeaseTerm leaseTerm;
}
