package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Represents the entity for the "Room Basic Attribute Values Table".
 * This class is used to map the data from the "attr_value" table in the database.
 * It extends the {@link BaseEntity} class, inheriting common fields.
 */
@Schema(description = "Room Basic Attribute Values Table")
@TableName(value = "attr_value")
@Data
public class AttrValue extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The attribute value.
     */
    @Schema(description = "Attribute value")
    @TableField(value = "name")
    private String name;

    /**
     * The ID of the associated attribute key.
     */
    @Schema(description = "Associated Attribute key_iD")
    @TableField(value = "attr_key_id")
    private Long attrKeyId;
}