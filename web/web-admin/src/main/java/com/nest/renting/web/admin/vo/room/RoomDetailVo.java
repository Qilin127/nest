package com.nest.renting.web.admin.vo.room;

import com.nest.renting.model.entity.*;
import com.nest.renting.web.admin.vo.attr.AttrValueVo;
import com.nest.renting.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Schema(description = "Room Information")
@Data
public class RoomDetailVo extends RoomInfo {

    @Schema(description = "Associated apartment information")
    private ApartmentInfo apartmentInfo;

    @Schema(description = "List of images")
    private List<GraphVo> graphVoList;

    @Schema(description = "List of attribute values")
    private List<AttrValueVo> attrValueVoList;

    @Schema(description = "List of facility information")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "List of tag information")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "List of payment methods")
    private List<PaymentType> paymentTypeList;

    @Schema(description = "List of available lease terms")
    private List<LeaseTerm> leaseTermList;
}
