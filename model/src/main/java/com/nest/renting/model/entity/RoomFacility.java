package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Room & Facility Association Table")
@TableName(value = "room_facility")
@Data
// @Builder
public class RoomFacility extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Room ID")
    @TableField(value = "room_id")
    private Long roomId;

    @Schema(description = "Facility ID")
    @TableField(value = "facility_id")
    private Long facilityId;

}