package com.nest.renting.web.app.vo.fee;

import com.nest.renting.model.entity.FeeKey;
import com.nest.renting.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

/**
 * FeeKeyVo represents the key information for fees, including a list of associated fee values.
 */
@Data
public class FeeKeyVo extends FeeKey {

    @Schema(description = "List of fee values")
    private List<FeeValue> feeValueList;
}
