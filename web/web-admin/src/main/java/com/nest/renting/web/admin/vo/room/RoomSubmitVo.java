package com.nest.renting.web.admin.vo.room;

import com.nest.renting.model.entity.RoomInfo;
import com.nest.renting.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Data
@Schema(description = "Room Information for Submission")
public class RoomSubmitVo extends RoomInfo {

    @Schema(description = "List of images")
    private List<GraphVo> graphVoList;

    @Schema(description = "List of attribute value IDs")
    private List<Long> attrValueIds;

    @Schema(description = "List of facility IDs")
    private List<Long> facilityInfoIds;

    @Schema(description = "List of label IDs")
    private List<Long> labelInfoIds;

    @Schema(description = "List of payment method IDs")
    private List<Long> paymentTypeIds;

    @Schema(description = "List of lease term IDs")
    private List<Long> leaseTermIds;

}
