package com.nest.renting.web.admin.vo.attr;

import com.nest.renting.model.entity.AttrKey;
import com.nest.renting.model.entity.AttrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * List<AttrKeyVo> is equivalent to: List<name, List<AttrValue>>
 */
@Data
public class AttrKeyVo extends AttrKey {

    @Schema(description = "List of attribute values")
    private List<AttrValue> attrValueList;
}
