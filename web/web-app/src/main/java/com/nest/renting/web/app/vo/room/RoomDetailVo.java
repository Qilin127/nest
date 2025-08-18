package com.nest.renting.web.app.vo.room;

import com.nest.renting.model.entity.*;
import com.nest.renting.web.app.vo.apartment.ApartmentItemVo;
import com.nest.renting.web.app.vo.attr.AttrValueVo;
import com.nest.renting.web.app.vo.fee.FeeValueVo;
import com.nest.renting.web.app.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * RoomDetailVo represents detailed information about a room, including associated apartment details, 
 * images, attributes, facilities, labels, payment methods, fees, and lease terms.
 */
@Data
@Schema(description = "Room Details for APP")
public class RoomDetailVo extends RoomInfo {

    @Schema(description = "Associated Apartment Information")
    private ApartmentItemVo apartmentItemVo;

    @Schema(description = "Image List")
    private List<GraphVo> graphVoList;

    @Schema(description = "Attribute Information List")
    private List<AttrValueVo> attrValueVoList;

    @Schema(description = "Facility Information List")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "Label Information List")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "Payment Method List")
    private List<PaymentType> paymentTypeList;

    @Schema(description = "Miscellaneous Fee List")
    private List<FeeValueVo> feeValueVoList;

    @Schema(description = "Lease Term List")
    private List<LeaseTerm> leaseTermList;

}
