package com.nest.renting.web.admin.vo.apartment;

import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.model.entity.FacilityInfo;
import com.nest.renting.model.entity.LabelInfo;
import com.nest.renting.web.admin.vo.fee.FeeValueVo;
import com.nest.renting.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Apartment Details")
@Data
public class ApartmentDetailVo extends ApartmentInfo {

    @Schema(description = "List of images")
    private List<GraphVo> graphVoList;

    @Schema(description = "List of tags")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "List of facilities")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "List of miscellaneous fees")
    private List<FeeValueVo> feeValueVoList;

}
