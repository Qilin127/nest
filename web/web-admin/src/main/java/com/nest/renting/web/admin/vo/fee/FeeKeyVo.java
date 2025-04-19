package com.nest.renting.web.admin.vo.fee;

import com.nest.renting.model.entity.FeeKey;
import com.nest.renting.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Data
public class FeeKeyVo extends FeeKey {

    @Schema(description = "List of miscellaneous fee values")
    private List<FeeValue> feeValueList;
}
