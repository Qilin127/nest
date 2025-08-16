package com.nest.renting.web.app.controller.room;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nest.renting.common.result.Result;

@Tag(name = "Room Information")
@RestController
@RequestMapping("/app/room")
public class RoomController {

    @Operation(summary = "Paginated query room list")
    @GetMapping("pageItem")
    public Result pageItem(@RequestParam long current, @RequestParam long size) {
        return Result.ok();
    }

    @Operation(summary = "Get detailed information about the room by id")
    @GetMapping("getDetailById")
    public Result getDetailById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "Query room list by paging based on apartment ID")
    @GetMapping("pageItemByApartmentId")
    public Result pageItemByApartmentId(@RequestParam long current, @RequestParam long size, @RequestParam Long id) {
        return Result.ok();
    }

}
