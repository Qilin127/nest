package com.nest.renting.web.admin.vo.apartment;

import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * The `ApartmentSubmitVo` class serves as a View Object (VO) designed to encapsulate the information
 * required for submitting apartment details. It extends the `ApartmentInfo` class, adding additional
 * fields for apartment facilities, labels, miscellaneous fees, and images. The basic `ApartmentInfo`
 * class does not include these extended details, so this VO is used to handle the submission process.
 */
@Schema(description = "Apartment Submission Information")
@Data
public class ApartmentSubmitVo extends ApartmentInfo {

    /**
     * A list containing the IDs of the facilities associated with the apartment.
     * These IDs correspond to the facilities available in the apartment.
     */
    @Schema(description = "IDs of apartment facilities")
    private List<Long> facilityInfoIds;

    /**
     * A list containing the IDs of the labels associated with the apartment.
     * These IDs represent tags or labels that describe the apartment.
     */
    @Schema(description = "IDs of apartment labels")
    private List<Long> labelIds;

    /**
     * A list containing the IDs of the miscellaneous fees associated with the apartment.
     * These IDs correspond to the additional fees applicable to the apartment.
     */
    @Schema(description = "IDs of apartment miscellaneous fees")
    private List<Long> feeValueIds;

    /**
     * A list of `GraphVo` objects representing the images of the apartment.
     * Each `GraphVo` object contains information about an individual image.
     */
    @Schema(description = "Apartment image list")
    private List<GraphVo> graphVoList;

}
