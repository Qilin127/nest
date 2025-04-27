package com.nest.renting.web.admin.vo.attr;

import com.nest.renting.model.entity.AttrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema(description = "Attribute Value")
@Data
public class AttrValueVo extends AttrValue {

    @Schema(description = "Corresponding attribute key name")
    private String attrKeyName;
}
