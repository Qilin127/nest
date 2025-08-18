package com.nest.renting.web.app.vo.apartment;

import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.model.entity.LabelInfo;
import com.nest.renting.web.app.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * ApartmentItemVo represents basic information about an apartment for the APP, 
 * including labels, images, and minimum rent.
 */

@Data
@Schema(description = "Apartment Information for APP")
public class ApartmentItemVo extends ApartmentInfo {

    private List<LabelInfo> labelInfoList;

    private List<GraphVo> graphVoList;

    private BigDecimal minRent;
}
