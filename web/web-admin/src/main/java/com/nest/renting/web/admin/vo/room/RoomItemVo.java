package com.nest.renting.web.admin.vo.room;

import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.model.entity.RoomInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * Represents the detailed information of a room item.
 * This class extends the {@link RoomInfo} class and adds additional information
 * such as the lease end date, check - in status, and associated apartment information.
 */
@Data
@Schema(description = "Room Information")
public class RoomItemVo extends RoomInfo {

    /**
     * The end date of the room lease.
     */
    @Schema(description = "Lease end date")
    private Date leaseEndDate;

    /**
     * Indicates whether the room is currently checked - in.
     * {@code true} if the room is checked in, {@code false} otherwise.
     */
    @Schema(description = "Current check-in status")
    private Boolean isCheckIn;

    /**
     * The associated apartment information of the room.
     */
    @Schema(description = "Associated apartment information")
    private ApartmentInfo apartmentInfo;

}
