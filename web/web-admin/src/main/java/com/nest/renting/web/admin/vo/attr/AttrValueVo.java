package com.nest.renting.web.admin.vo.attr;

import com.nest.renting.model.entity.AttrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents the view object for attribute values.
 * This class extends the {@link com.nest.renting.model.entity.AttrValue} entity
 * and adds an additional field to store the corresponding attribute key name.
 */
@Schema(description = "Attribute Value")
@Data
public class AttrValueVo extends AttrValue {

    /**
     * The name of the corresponding attribute key.
     * This field provides additional context about the attribute value
     * by indicating the name of the associated attribute key.
     */
    @Schema(description = "Corresponding attribute key name")
    private String attrKeyName;
}
