package com.nest.renting.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nest.renting.common.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.RoomInfo;
import com.nest.renting.model.enums.ReleaseStatus;
import com.nest.renting.web.admin.service.RoomInfoService;
import com.nest.renting.web.admin.vo.room.RoomDetailVo;
import com.nest.renting.web.admin.vo.room.RoomItemVo;
import com.nest.renting.web.admin.vo.room.RoomQueryVo;
import com.nest.renting.web.admin.vo.room.RoomSubmitVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Room information management")
@RestController
@RequestMapping("/admin/room")
public class RoomController {

    @Autowired
    private RoomInfoService roomInfoService;

    /**
     * Save or update room information.
     * @param roomSubmitVo the room data submitted from the client
     * @return success result
     * @author Qilin Wang
     */
    @Operation(summary = "Save or update room information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody RoomSubmitVo roomSubmitVo) {
        roomInfoService.saveOrUpdateRoom(roomSubmitVo);
        return Result.ok();
    }


    /**
     * Retrieve a paginated list of rooms based on query conditions such as location.
     * @param current current page number
     * @param size page size
     * @param queryVo query conditions encapsulated in RoomQueryVo
     * @return paginated list of RoomItemVo wrapped in Result
     * @author Qilin Wang
     */
    @Operation(summary = "Retrieve a paginated list of rooms based on conditions (e.g., location)")
    @GetMapping("pageItem")
    public Result<IPage<RoomItemVo>> pageItem(@RequestParam long current, @RequestParam long size, RoomQueryVo queryVo) {
        IPage<RoomItemVo> itemVoIPage = new Page<>(current, size);
        IPage<RoomItemVo> result = roomInfoService.pageRoomItemByQuery(itemVoIPage, queryVo);
        return Result.ok(result);
    }

    /**
     * Get detailed room information by room ID.
     * @param id the room ID
     * @return detailed room information wrapped in Result
     * @author Qilin Wang
     */
    @Operation(summary = "Get detailed room information by ID")
    @GetMapping("getDetailById")
    public Result<RoomDetailVo> getDetailById(@RequestParam Long id) {
        RoomDetailVo roomDetailVo = roomInfoService.getDetailById(id);
        return Result.ok(roomDetailVo);
    }

    /**
     * Delete room information by room ID.
     * @param id the room ID
     * @return success result
     * @author Qilin Wang
     */
    @Operation(summary = "Delete room information by ID")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        roomInfoService.removeRoomById(id);
        return Result.ok();
    }

    /**
     * Update the release status of a room by its ID.
     * @param id the room ID
     * @param status the new release status
     * @return success result
     * @author Qilin Wang
     */
    @Operation(summary = "Update the room’s release status by ID")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(Long id, ReleaseStatus status) {
        LambdaUpdateWrapper<RoomInfo> roomInfoLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        roomInfoLambdaUpdateWrapper.eq(RoomInfo::getId, id)
                .set(RoomInfo::getIsRelease, status);
        roomInfoService.update(roomInfoLambdaUpdateWrapper);
        return Result.ok();
    }

    /**
     * Retrieve the list of rooms by apartment ID, filtering only released rooms.
     * @param id the apartment ID
     * @return list of RoomInfo wrapped in Result
     * @author Qilin Wang
     */
    @GetMapping("listBasicByApartmentId")
    @Operation(summary = "Retrieve the list of rooms by apartment ID")
    public Result<List<RoomInfo>> listBasicByApartmentId(Long id) {
        LambdaQueryWrapper<RoomInfo> roomInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // FIXME: Is it necessary to release the "unreleased" properties?
        //  Because the background management system needs to see all the status of the properties
        roomInfoLambdaQueryWrapper.eq(RoomInfo::getApartmentId, id)
                .eq(RoomInfo::getIsRelease, ReleaseStatus.RELEASED);
        List<RoomInfo> list = roomInfoService.list(roomInfoLambdaQueryWrapper);
        return Result.ok(list);
    }

}


















