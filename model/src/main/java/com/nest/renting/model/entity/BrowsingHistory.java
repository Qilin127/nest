package com.nest.renting.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Represents the browsing history of users for rooms.
 * This entity is mapped to the 'browsing_history' table in the database.
 * It extends the {@link BaseEntity} class, inheriting common fields such as ID, creation time, etc.
 */
@TableName(value = "browsing_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrowsingHistory extends BaseEntity {

    /**
     * Serial version UID for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The ID of the user who browsed the room.
     */
    @Schema(description = "User ID")
    @TableField("user_id")
    private Long userId;

    /**
     * The ID of the room that was browsed.
     */
    @Schema(description = "Room ID")
    @TableField("room_id")
    private Long roomId;

    /**
     * The time when the user browsed the room.
     * The date format is 'yyyy-MM-dd HH:mm:ss'.
     */
    @Schema(description = "Browse Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("browse_time")
    private Date browseTime;

}