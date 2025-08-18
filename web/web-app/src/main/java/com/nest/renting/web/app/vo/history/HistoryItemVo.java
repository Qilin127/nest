package com.nest.renting.web.app.vo.history;

import com.nest.renting.model.entity.BrowsingHistory;
import com.nest.renting.web.app.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

/**
 * HistoryItemVo represents basic information about browsing history, including room details, rent, and location.
 */
@Data
@Schema(description = "Basic Information of Browsing History")
public class HistoryItemVo extends BrowsingHistory {

    @Schema(description = "Room Number")
    private String roomNumber;

    @Schema(description = "Rent")
    private BigDecimal rent;

    @Schema(description = "Room Image List")
    private List<GraphVo> roomGraphVoList;

    @Schema(description = "Apartment Name")
    private String apartmentName;

    @Schema(description = "Province Name")
    private String provinceName;

    @Schema(description = "City Name")
    private String cityName;

    @Schema(description = "District Name")
    private String districtName;

}
