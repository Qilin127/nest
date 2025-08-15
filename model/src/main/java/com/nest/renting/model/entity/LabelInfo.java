package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.nest.renting.model.enums.ItemType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Represents the Label Information Table in the database.
 * This class extends the BaseEntity and stores information about labels,
 * including the associated object type and label name.
 */
@Schema(description = "Label Information Table")
@TableName(value = "label_info")
@Data
public class LabelInfo extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The type of the associated object.
     */
    @Schema(description = "Associated Object Type")
    @TableField(value = "type")
    private ItemType type;

    /**
     * The name of the label.
     */
    @Schema(description = "Label Name")
    @TableField(value = "name")
    private String name;


}