package com.nest.renting.web.admin.vo.fee;

import com.nest.renting.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Miscellaneous Fee Value")
@Data
public class FeeValueVo extends FeeValue {

    @Schema(description = "Name of the corresponding fee key")
    private String feeKeyName;
}
