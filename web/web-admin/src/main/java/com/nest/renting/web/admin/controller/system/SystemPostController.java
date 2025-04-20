package com.nest.renting.web.admin.controller.system;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        IPage<SystemPost> systemPostIPage = new Page<>(current, size);
        IPage<SystemPost> result = systemPostService.page(systemPostIPage);
        return Result.ok(result);
    }

    @Operation(summary = "Save or update position information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemPost systemPost) {
        systemPostService.saveOrUpdate(systemPost);
        return Result.ok();
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "Delete a position by ID")
    public Result removeById(@RequestParam Long id) {
        systemPostService.removeById(id);
        return Result.ok();
    }

    @GetMapping("getById")
    @Operation(summary = "Get position details by ID")
    public Result<SystemPost> getById(@RequestParam Long id) {
        SystemPost systemPost = systemPostService.getById(id);
        return Result.ok(systemPost);
    }

    @Operation(summary = "Retrieve the full list of positions")
    @GetMapping("list")
    public Result<List<SystemPost>> list() {
        List<SystemPost> systemPostList = systemPostService.list();
        return Result.ok(systemPostList);
    }

    @Operation(summary = "Update the status of a position by its ID")
    @PostMapping("updateStatusByPostId")
    public Result updateStatusByPostId(@RequestParam Long id, @RequestParam BaseStatus status) {
        LambdaUpdateWrapper<SystemPost> systemPostLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        systemPostLambdaUpdateWrapper.eq(SystemPost::getId, id);
        systemPostLambdaUpdateWrapper.set(SystemPost::getStatus, status);
        systemPostService.update(systemPostLambdaUpdateWrapper);
        return Result.ok();
    }
}
