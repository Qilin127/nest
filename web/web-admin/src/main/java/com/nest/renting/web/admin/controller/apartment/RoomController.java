package com.nest.renting.web.admin.controller.apartment;

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

    @Operation(summary = "Save or update room information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody RoomSubmitVo roomSubmitVo) {
        roomInfoService.saveOrUpdateRoom(roomSubmitVo);
        return Result.ok();
    }

    @Operation(summary = "Retrieve a paginated list of rooms based on conditions (e.g., location)")
    @GetMapping("pageItem")
    public Result<IPage<RoomItemVo>> pageItem(@RequestParam long current, @RequestParam long size, RoomQueryVo queryVo) {
        IPage<RoomItemVo> itemVoIPage = new Page<>(current, size);
        IPage<RoomItemVo> result = roomInfoService.pageRoomItemByQuery(itemVoIPage, queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "Get detailed room information by ID")
    @GetMapping("getDetailById")
    public Result<RoomDetailVo> getDetailById(@RequestParam Long id) {
        RoomDetailVo roomDetailVo = roomInfoService.getDetailById(id);
        return Result.ok(roomDetailVo);
    }

    @Operation(summary = "Delete room information by ID")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "Update the room’s release status by ID")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(Long id, ReleaseStatus status) {
        return Result.ok();
    }

    /**
     * 用于租约管理——新增租约的时候需要根据公寓查询所有房间
     * @param id
     * @return
     */
    @GetMapping("listBasicByApartmentId")
    @Operation(summary = "Retrieve the list of rooms by apartment ID")
    public Result<List<RoomInfo>> listBasicByApartmentId(Long id) {
        return Result.ok();
    }

}


















