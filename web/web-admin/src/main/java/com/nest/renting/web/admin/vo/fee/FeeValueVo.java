package com.nest.renting.web.admin.vo.fee;

import com.nest.renting.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents the view object for miscellaneous fee values.
 * This class extends the {@link FeeValue} entity and adds an additional field
 * to hold the name of the corresponding fee key.
 */
@Schema(description = "Miscellaneous Fee Value")
@Data
public class FeeValueVo extends FeeValue {

    /**
     * The name of the corresponding fee key.
     * This field provides the name associated with the fee key for this fee value.
     */
    @Schema(description = "Name of the corresponding fee key")
    private String feeKeyName;
}
