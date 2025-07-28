package com.nest.renting.web.admin.vo.fee;

import com.nest.renting.model.entity.FeeKey;
import com.nest.renting.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Represents the view object for fee keys, which extends the base FeeKey entity.
 * This class includes additional information about the list of fee values associated with the fee key.
 */
@Data
public class FeeKeyVo extends FeeKey {

    /**
     * A list of miscellaneous fee values associated with the fee key.
     */
    @Schema(description = "List of miscellaneous fee values")
    private List<FeeValue> feeValueList;
}
