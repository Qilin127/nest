package com.nest.renting.web.app.vo.fee;

import com.nest.renting.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * FeeValueVo represents the value of a fee, including the corresponding fee key name.
 */
@Schema(description = "Fee Value")
@Data
public class FeeValueVo extends FeeValue {

    @Schema(description = "Name of the corresponding fee key")
    private String feeKeyName;
}
