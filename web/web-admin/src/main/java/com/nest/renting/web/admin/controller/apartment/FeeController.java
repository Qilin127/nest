package com.nest.renting.web.admin.controller.apartment;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.FeeKey;
import com.nest.renting.model.entity.FeeValue;
import com.nest.renting.web.admin.service.FeeKeyService;
import com.nest.renting.web.admin.service.FeeValueService;
import com.nest.renting.web.admin.vo.fee.FeeKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Room fee management")
@RestController
@RequestMapping("/admin/fee")
public class FeeController {

    @Autowired
    private FeeKeyService feeKeyService;

    @Autowired
    private FeeValueService feeValueService;

    @Operation(summary = "Save or update fee category name")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateFeeKey(@RequestBody FeeKey feeKey) {
        feeKeyService.saveOrUpdate(feeKey);
        return Result.ok();
    }

    @Operation(summary = "Save or update fee value")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateFeeValue(@RequestBody FeeValue feeValue) {
        feeValueService.saveOrUpdate(feeValue);
        return Result.ok();
    }


    @Operation(summary = "Retrieve the full list of fee categories and their values")
    @GetMapping("list")
    public Result<List<FeeKeyVo>> feeInfoList() {
        List<FeeKeyVo> list = feeKeyService.feeInfoList();
        return Result.ok(list);
    }

    @Operation(summary = "Delete a fee category by ID")
    @DeleteMapping("key/deleteById")
    public Result deleteFeeKeyById(@RequestParam Long feeKeyId) {
        // 删除杂费类别名称
        feeKeyService.removeById(feeKeyId);

        // 删除杂费值元素
        LambdaQueryWrapper<FeeValue> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(FeeValue::getFeeKeyId, feeKeyId);
        feeValueService.remove(lambdaQueryWrapper);

        return Result.ok();
    }

    @Operation(summary = "Delete a fee value by ID")
    @DeleteMapping("value/deleteById")
    public Result deleteFeeValueById(@RequestParam Long id) {
        feeValueService.removeById(id);
        return Result.ok();
    }
}
