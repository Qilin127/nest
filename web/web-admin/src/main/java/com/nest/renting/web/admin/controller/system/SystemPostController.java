package com.nest.renting.web.admin.controller.system;

import com.nest.renting.common.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.SystemPost;
import com.nest.renting.model.enums.BaseStatus;
import com.nest.renting.web.admin.service.SystemPostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Tag(name = "Backend user position management")
@RequestMapping("/admin/system/post")
public class SystemPostController {

    @Autowired
    private SystemPostService systemPostService;

    @Operation(summary = "Retrieve position information with pagination")
    @GetMapping("page")
    private Result<IPage<SystemPost>> page(@RequestParam long current, @RequestParam long size) {
        return Result.ok();
    }

    @Operation(summary = "Save or update position information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemPost systemPost) {
        return Result.ok();
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "Delete a position by ID")
    public Result removeById(@RequestParam Long id) {
        return Result.ok();
    }

    @GetMapping("getById")
    @Operation(summary = "Get position details by ID")
    public Result<SystemPost> getById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "Retrieve the full list of positions")
    @GetMapping("list")
    public Result<List<SystemPost>> list() {
        return Result.ok();
    }

    @Operation(summary = "Update the status of a position by its ID")
    @PostMapping("updateStatusByPostId")
    public Result updateStatusByPostId(@RequestParam Long id, @RequestParam BaseStatus status) {
        return Result.ok();
    }
}
