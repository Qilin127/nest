package com.nest.renting.web.admin.vo.apartment;

import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * The basic ApartmentInfo class does not include information such as images, miscellaneous fees, or tags.
 * Use a VO (View Object) for those extended details.
 */
@Schema(description = "Apartment Submission Information")
@Data
public class ApartmentSubmitVo extends ApartmentInfo {

    @Schema(description = "IDs of apartment facilities")
    private List<Long> facilityInfoIds;

    @Schema(description = "IDs of apartment labels")
    private List<Long> labelIds;

    @Schema(description = "IDs of apartment miscellaneous fees")
    private List<Long> feeValueIds;

    @Schema(description = "Apartment image list")
    private List<GraphVo> graphVoList;

}
