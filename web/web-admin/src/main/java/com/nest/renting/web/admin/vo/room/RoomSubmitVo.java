package com.nest.renting.web.admin.vo.room;

import com.nest.renting.model.entity.RoomInfo;
import com.nest.renting.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Represents the submission information for a room.
 * This class extends {@link RoomInfo} and includes additional information
 * such as lists of image data, attribute value IDs, facility IDs, label IDs,
 * payment method IDs, and lease term IDs.
 */
@Data
@Schema(description = "Room Information for Submission")
public class RoomSubmitVo extends RoomInfo {

    /**
     * A list of image data associated with the room.
     */
    @Schema(description = "List of images")
    private List<GraphVo> graphVoList;

    /**
     * A list of attribute value IDs related to the room.
     */
    @Schema(description = "List of attribute value IDs")
    private List<Long> attrValueIds;

    /**
     * A list of facility IDs associated with the room.
     */
    @Schema(description = "List of facility IDs")
    private List<Long> facilityInfoIds;

    /**
     * A list of label IDs related to the room.
     */
    @Schema(description = "List of label IDs")
    private List<Long> labelInfoIds;

    /**
     * A list of payment method IDs available for the room.
     */
    @Schema(description = "List of payment method IDs")
    private List<Long> paymentTypeIds;

    /**
     * A list of lease term IDs applicable to the room.
     */
    @Schema(description = "List of lease term IDs")
    private List<Long> leaseTermIds;

}
