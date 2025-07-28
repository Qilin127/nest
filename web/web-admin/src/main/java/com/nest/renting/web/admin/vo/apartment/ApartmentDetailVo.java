package com.nest.renting.web.admin.vo.apartment;

import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.model.entity.FacilityInfo;
import com.nest.renting.model.entity.LabelInfo;
import com.nest.renting.web.admin.vo.fee.FeeValueVo;
import com.nest.renting.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Represents the detailed information of an apartment.
 * This class extends {@link ApartmentInfo} and includes additional information
 * such as lists of images, tags, facilities, and miscellaneous fees.
 */
@Schema(description = "Apartment Details")
@Data
public class ApartmentDetailVo extends ApartmentInfo {

    /**
     * A list of image information for the apartment.
     */
    @Schema(description = "List of images")
    private List<GraphVo> graphVoList;

    /**
     * A list of tag information associated with the apartment.
     */
    @Schema(description = "List of tags")
    private List<LabelInfo> labelInfoList;

    /**
     * A list of facility information available in the apartment.
     */
    @Schema(description = "List of facilities")
    private List<FacilityInfo> facilityInfoList;

    /**
     * A list of miscellaneous fee information for the apartment.
     */
    @Schema(description = "List of miscellaneous fees")
    private List<FeeValueVo> feeValueVoList;

}
