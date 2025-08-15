package com.nest.renting.web.admin.vo.room;

import com.nest.renting.model.entity.*;
import com.nest.renting.web.admin.vo.attr.AttrValueVo;
import com.nest.renting.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Represents detailed information about a room.
 * This class extends {@link RoomInfo} and includes additional information
 * such as associated apartment details, images, attribute values, facilities,
 * tags, payment methods, and available lease terms.
 */
@Schema(description = "Room Information")
@Data
public class RoomDetailVo extends RoomInfo {

    /**
     * Associated apartment information for the room.
     */
    @Schema(description = "Associated apartment information")
    private ApartmentInfo apartmentInfo;

    /**
     * List of images related to the room.
     */
    @Schema(description = "List of images")
    private List<GraphVo> graphVoList;

    /**
     * List of attribute values associated with the room.
     */
    @Schema(description = "List of attribute values")
    private List<AttrValueVo> attrValueVoList;

    /**
     * List of facility information available in the room.
     */
    @Schema(description = "List of facility information")
    private List<FacilityInfo> facilityInfoList;

    /**
     * List of tag information associated with the room.
     */
    @Schema(description = "List of tag information")
    private List<LabelInfo> labelInfoList;

    /**
     * List of payment methods available for the room.
     */
    @Schema(description = "List of payment methods")
    private List<PaymentType> paymentTypeList;

    /**
     * List of available lease terms for the room.
     */
    @Schema(description = "List of available lease terms")
    private List<LeaseTerm> leaseTermList;
}
