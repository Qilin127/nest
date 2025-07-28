package com.nest.renting.web.admin.vo.agreement;

import com.nest.renting.model.entity.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents the view object for lease agreement information.
 * This class extends the {@link LeaseAgreement} entity and includes additional
 * related information such as apartment details, room details, payment method, and lease term.
 */
@Data
@Schema(description = "Lease Agreement Information")
public class AgreementVo extends LeaseAgreement {

    /**
     * Information about the apartment where the lease agreement is signed.
     */
    @Schema(description = "Signed apartment information")
    private ApartmentInfo apartmentInfo;

    /**
     * Information about the room where the lease agreement is signed.
     */
    @Schema(description = "Signed room information")
    private RoomInfo roomInfo;

    /**
     * The payment method used for the lease agreement.
     */
    @Schema(description = "Payment method")
    private PaymentType paymentType;

    /**
     * The lease term of the agreement.
     */
    @Schema(description = "Lease term")
    private LeaseTerm leaseTerm;
}
