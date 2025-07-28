package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.nest.renting.model.enums.ItemType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * Represents the image information entity, corresponding to the 'graph_info' table in the database.
 * This class inherits from {@link BaseEntity} and stores details about images,
 * such as name, associated object type, associated object ID, and image URL.
 */
@Schema(description = "Image Information Table")
@TableName(value = "graph_info")
@Data
public class GraphInfo extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The name of the image.
     */
    @Schema(description = "Image Name")
    @TableField(value = "name")
    private String name;

    /**
     * The type of the associated object.
     */
    @Schema(description = "Associated Object Type")
    @TableField(value = "item_type")
    private ItemType itemType;

    /**
     * The ID of the associated object.
     */
    @Schema(description = "Associated Object ID")
    @TableField(value = "item_id")
    private Long itemId;

    /**
     * The URL of the image.
     */
    @Schema(description = "Image URL")
    @TableField(value = "url")
    private String url;

}