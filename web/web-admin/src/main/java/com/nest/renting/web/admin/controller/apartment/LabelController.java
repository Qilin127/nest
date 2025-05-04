package com.nest.renting.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.LabelInfo;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.admin.service.LabelInfoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Label Management")
@RestController
@RequestMapping("/admin/label")
public class LabelController {
@Autowired
    private LabelInfoService service;
    @Operation(summary = "Retrieve the tag list by type")
    @GetMapping("list")
    public Result<List<LabelInfo>> labelList(@RequestParam(required = false) ItemType type) {
         LambdaQueryWrapper<LabelInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(type != null, LabelInfo::getType, type);
        List<LabelInfo> list = service.list(queryWrapper);
        return Result.ok(list);
    }

    @Operation(summary = "Add or update tag information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdateLabel(@RequestBody LabelInfo labelInfo) {
        return Result.ok();
    }

    @Operation(summary = "Delete tag information by ID")
    @DeleteMapping("deleteById")
    public Result deleteLabelById(@RequestParam Long id) {
        return Result.ok();
    }
}
