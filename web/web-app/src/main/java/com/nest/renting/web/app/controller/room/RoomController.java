package com.nest.renting.web.app.controller.room;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nest.renting.common.result.Result;
import com.nest.renting.web.app.service.RoomInfoService;
import com.nest.renting.web.app.vo.room.RoomDetailVo;
import com.nest.renting.web.app.vo.room.RoomItemVo;
import com.nest.renting.web.app.vo.room.RoomQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RoomController
 *
 * Controller for handling room-related requests in the rental application.
 * Provides endpoints for retrieving room lists and detailed room information.
 *
 * Author: Yuze Wang, Yuxuan Shi
 * Date: September 22, 2025
 */
@Tag(name = "Room Information")
@RestController
@RequestMapping("/app/room")
public class RoomController {

    @Autowired
    private RoomInfoService roomInfoService;

    /**
     * Retrieve a paginated list of rooms based on query conditions.
     *
     * @param current the current page number
     * @param size the number of records per page
     * @param queryVo the query conditions for filtering rooms
     * @return a paginated list of room items wrapped in a {@link Result}
     */
    @Operation(summary = "Get paginated room list")
    @GetMapping("pageItem")
    public Result<IPage<RoomItemVo>> pageItem(@RequestParam long current,
                                              @RequestParam long size,
                                              RoomQueryVo queryVo) {
        IPage<RoomItemVo> roomItemVoIPage = new Page<>(current, size);
        IPage<RoomItemVo> result = roomInfoService.pageItem(roomItemVoIPage, queryVo);
        return Result.ok(result);
    }

    /**
     * Retrieve detailed information about a specific room by its ID.
     *
     * @param id the room ID
     * @return detailed room information wrapped in a {@link Result}
     */
    @Operation(summary = "Get room details by ID")
    @GetMapping("getDetailById")
    public Result<RoomDetailVo> getDetailById(@RequestParam Long id) {
        RoomDetailVo result = roomInfoService.getDetailById(id);
        return Result.ok(result);
    }

    /**
     * Retrieve a paginated list of rooms under a specific apartment.
     * This endpoint is primarily used on the apartment detail page
     * to display all available rooms under the apartment.
     *
     * @param current the current page number
     * @param size the number of records per page
     * @param id the apartment ID
     * @return a paginated list of room items belonging to the apartment, wrapped in a {@link Result}
     */
    @Operation(summary = "Get paginated room list by apartment ID")
    @GetMapping("pageItemByApartmentId")
    public Result<IPage<RoomItemVo>> pageItemByApartmentId(@RequestParam long current,
                                                           @RequestParam long size,
                                                           @RequestParam Long id) {
        IPage<RoomItemVo> roomItemVoIPage = new Page<>(current, size);
        IPage<RoomItemVo> result = roomInfoService.pageItemByApartmentId(roomItemVoIPage, id);
        return Result.ok(result);
    }
}

