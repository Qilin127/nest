package com.nest.renting.web.app.vo.room;

import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.model.entity.LabelInfo;
import com.nest.renting.web.app.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * RoomItemVo represents a room entity in the APP room list, including details such as rent, images, labels, 
 * and associated apartment information.
 */
@Schema(description = "Room List Entity for APP")
@Data
public class RoomItemVo {

    @Schema(description = "Room ID")
    private Long id;

    @Schema(description = "Room Number")
    private String roomNumber;

    @Schema(description = "Rent (in currency per month)")
    private BigDecimal rent;

    @Schema(description = "Room Image List")
    private List<GraphVo> graphVoList;

    @Schema(description = "Room Label List")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "Associated Apartment Information")
    private ApartmentInfo apartmentInfo;

}
