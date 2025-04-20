package com.nest.renting.web.admin.controller.apartment;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.LabelInfo;
import com.nest.renting.model.entity.RoomLabel;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.admin.service.LabelInfoService;
import com.nest.renting.web.admin.service.RoomLabelService;
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
    private LabelInfoService labelInfoService;
    @Autowired
    private RoomLabelService roomLabelService;

    @Operation(summary = "Retrieve the tag list by type")
    @GetMapping("list")
    public Result<List<LabelInfo>> labelList(@RequestParam(required = false) ItemType type) {
        LambdaQueryWrapper<LabelInfo> queryWrapper = new LambdaQueryWrapper<LabelInfo>();
        queryWrapper.eq(type != null, LabelInfo::getType, type);
        List<LabelInfo> list = labelInfoService.list(queryWrapper);
        return Result.ok(list);
    }

    @Operation(summary = "Add or update tag information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdateLabel(@RequestBody LabelInfo labelInfo) {
        labelInfoService.saveOrUpdate(labelInfo);
        return Result.ok();
    }

    @Operation(summary = "Delete tag information by ID")
    @DeleteMapping("deleteById")
    public Result deleteLabelById(@RequestParam Long id) {
        labelInfoService.removeById(id);
        // Optimization: After deleting tag information, the corresponding relationships in the association table should also be removed.
        roomLabelService.remove(new QueryWrapper<RoomLabel>().eq("label_id", id));
        return Result.ok();
    }
}
