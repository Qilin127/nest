package com.nest.renting.web.app.vo.attr;

import com.nest.renting.model.entity.AttrKey;
import com.nest.renting.model.entity.AttrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

/**
 * AttrKeyVo represents an attribute key entity, including a list of associated attribute values.
 */
@Data
public class AttrKeyVo extends AttrKey {

    @Schema(description = "Attribute value list")
    private List<AttrValue> attrValueList;
}