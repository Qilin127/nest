package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Represents the entity of the room details table, which stores attribute keys related to room details.
 * This class extends the BaseEntity, inheriting common fields and behaviors.
 */
@Schema(description = "Room Details Table")
@TableName(value = "attr_key")
@Data
public class AttrKey extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The attribute key associated with room details.
     */
    @Schema(description = "Attribute key")
    @TableField(value = "name")
    private String name;

}