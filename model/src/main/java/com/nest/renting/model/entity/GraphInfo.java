package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.nest.renting.model.enums.ItemType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Schema(description = "Image Information Table")
@TableName(value = "graph_info")
@Data
public class GraphInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Image Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Associated Object Type")
    @TableField(value = "item_type")
    private ItemType itemType;

    @Schema(description = "Associated Object ID")
    @TableField(value = "item_id")
    private Long itemId;

    @Schema(description = "Image URL")
    @TableField(value = "url")
    private String url;

}