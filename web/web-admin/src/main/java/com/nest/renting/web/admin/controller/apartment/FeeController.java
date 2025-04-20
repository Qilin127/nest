package com.nest.renting.web.admin.controller.apartment;


import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.FeeKey;
import com.nest.renting.model.entity.FeeValue;
import com.nest.renting.web.admin.vo.fee.FeeKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Room fee management")
@RestController
@RequestMapping("/admin/fee")
public class FeeController {

    @Operation(summary = "Save or update fee category name")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateFeeKey(@RequestBody FeeKey feeKey) {
        return Result.ok();
    }

    @Operation(summary = "Save or update fee value")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateFeeValue(@RequestBody FeeValue feeValue) {
        return Result.ok();
    }


    @Operation(summary = "Retrieve the full list of fee categories and their values")
    @GetMapping("list")
    public Result<List<FeeKeyVo>> feeInfoList() {
        return Result.ok();
    }

    @Operation(summary = "Delete a fee category by ID")
    @DeleteMapping("key/deleteById")
    public Result deleteFeeKeyById(@RequestParam Long feeKeyId) {
        return Result.ok();
    }

    @Operation(summary = "Delete a fee value by ID")
    @DeleteMapping("value/deleteById")
    public Result deleteFeeValueById(@RequestParam Long id) {
        return Result.ok();
    }
}
