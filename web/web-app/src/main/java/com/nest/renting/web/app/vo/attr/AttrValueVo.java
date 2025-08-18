package com.nest.renting.web.app.vo.attr;

import com.nest.renting.model.entity.AttrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * AttrValueVo represents an attribute value entity, including the name of the corresponding attribute key.
 */
@Schema(description = "Attribute Value")
@Data
public class AttrValueVo extends AttrValue {

    @Schema(description = "Corresponding Attribute Key Name")
    private String attrKeyName;
}
