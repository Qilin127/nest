package com.nest.renting.web.app.vo.apartment;

import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.model.entity.FacilityInfo;
import com.nest.renting.model.entity.LabelInfo;
import com.nest.renting.web.app.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * ApartmentDetailVo represents detailed information about an apartment, 
 * including images, labels, facilities, and minimum rent.
 */

@Data
@Schema(description = "Apartment Details for APP")
public class ApartmentDetailVo extends ApartmentInfo {

    @Schema(description = "Image List")
    private List<GraphVo> graphVoList;

    @Schema(description = "Label List")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "Facility List")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "Minimum Rent")
    private BigDecimal minRent;
}
