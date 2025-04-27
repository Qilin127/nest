package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Room & Label Association Table")
@TableName(value = "room_label")
@Data
// @Builder
public class RoomLabel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Room ID")
    @TableField(value = "room_id")
    private Long roomId;

    @Schema(description = "Label ID")
    @TableField(value = "label_id")
    private Long labelId;

}