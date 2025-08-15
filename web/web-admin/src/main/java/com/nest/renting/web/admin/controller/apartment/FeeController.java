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

    /**
     * Save or update a fee category name.
     *
     * @param feeKey The FeeKey object containing the fee category data to be saved or updated.
     * @return A Result object indicating the success of the operation.
     */
    @Operation(summary = "Save or update fee category name")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateFeeKey(@RequestBody FeeKey feeKey) {
        feeKeyService.saveOrUpdate(feeKey);
        return Result.ok();
    }

    /**
     * Save or update a fee value.
     *
     * @param feeValue The FeeValue object containing the fee value data to be saved or updated.
     * @return A Result object indicating the success of the operation.
     */
    @Operation(summary = "Save or update fee value")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateFeeValue(@RequestBody FeeValue feeValue) {
        feeValueService.saveOrUpdate(feeValue);
        return Result.ok();
    }

    /**
     * Retrieve the full list of fee categories and their values.
     *
     * @return A Result object containing the list of FeeKeyVo objects.
     */
    @Operation(summary = "Retrieve the full list of fee categories and their values")
    @GetMapping("list")
    public Result<List<FeeKeyVo>> feeInfoList() {
        List<FeeKeyVo> list = feeKeyService.feeInfoList();
        return Result.ok();
    }

    /**
     * Delete a fee category by ID.
     *
     * @param feeKeyId The ID of the fee category to be deleted.
     * @return A Result object indicating the success of the operation.
     */
    @Operation(summary = "Delete a fee category by ID")
    @DeleteMapping("key/deleteById")
    public Result deleteFeeKeyById(@RequestParam Long feeKeyId) {
    //Delete the name of the miscellaneous fee
    feeKeyService.removeById(feeKeyId);
    //Delete the miscellaneous fee value under the miscellaneous fee name
    LambdaQueryWrapper<FeeValue> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(FeeValue::getFeeKeyId, feeKeyId);
    feeValueService.remove(queryWrapper);
    return Result.ok();

    }

    /**
     * Delete a fee value by ID.
     *
     * @param id The ID of the fee value to be deleted.
     * @return A Result object indicating the success of the operation.
     */
    @Operation(summary = "Delete a fee value by ID")
    @DeleteMapping("value/deleteById")
    public Result deleteFeeValueById(@RequestParam Long id) {
        feeValueService.removeById(id);
        return Result.ok();
        
    }
}
