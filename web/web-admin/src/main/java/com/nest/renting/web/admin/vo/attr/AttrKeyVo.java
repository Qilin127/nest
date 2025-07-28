package com.nest.renting.web.admin.vo.attr;

import com.nest.renting.model.entity.AttrKey;
import com.nest.renting.model.entity.AttrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Represents a view object for attribute keys, extending the {@link AttrKey} entity.
 * This class includes additional information about the list of attribute values associated with the key.
 */
@Data
public class AttrKeyVo extends AttrKey {

    /**
     * List of attribute values associated with this attribute key.
     */
    @Schema(description = "List of attribute values")
    private List<AttrValue> attrValueList;
}
