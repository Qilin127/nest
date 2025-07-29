package com.nest.renting.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.AttrKey;
import com.nest.renting.model.entity.AttrValue;
import com.nest.renting.web.admin.service.AttrKeyService;
import com.nest.renting.web.admin.service.AttrValueService;
import com.nest.renting.web.admin.vo.attr.AttrKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing room attributes including attribute keys and values.
 * Provides endpoints to add, update, delete, and list attribute keys and values.
 */
@Tag(name = "Room attribute management")
@RestController
@RequestMapping("/admin/attr")
public class AttrController {
    @Autowired
    private AttrKeyService attrKeyService;
    @Autowired
    private AttrValueService attrValueService;

    /**
     * Add or update an attribute key.
     *
     * @param attrKey the attribute key entity to be saved or updated
     * @return a Result indicating success or failure
     */
    @Operation(summary = "Add or update attribute names")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateAttrKey(@RequestBody AttrKey attrKey) {
        attrKeyService.saveOrUpdate(attrKey);//Save or update attribute names
        return Result.ok();
    }

    /**
     * Add or update an attribute value.
     *
     * @param attrValue the attribute value entity to be saved or updated
     * @return a Result indicating success or failure
     */
    @Operation(summary = "Add or update attribute values")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateAttrValue(@RequestBody AttrValue attrValue) {
        attrValueService.saveOrUpdate(attrValue);
        return Result.ok();
    }

    /**
     * Retrieve the full list of attribute names and values.
     */
    @Operation(summary = "Retrieve the full list of attribute names and values")
    @GetMapping("list")
    public Result<List<AttrKeyVo>> listAttrInfo() {
        List<AttrKeyVo> list = attrKeyService.listAttrInfo();//List<AttrKeyVo> is equivalent to: List<name, List<AttrValue>>
        return Result.ok();
    }

    /**
     * Delete an attribute key (category) by its ID.
     * This method also deletes all attribute values associated with the given attribute key ID.
     *
     * @param attrKeyId the ID of the attribute key to be deleted
     * @return a Result indicating success of the deletion operation
     */
    @Operation(summary = "Delete an attribute name (category) by ID")
    @DeleteMapping("key/deleteById")
    public Result removeAttrKeyById(@RequestParam Long attrKeyId) {
         //Delete attrKey
        attrKeyService.removeById(attrKeyId);
        //Delete attrValue
        LambdaQueryWrapper<AttrValue> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AttrValue::getAttrKeyId, attrKeyId);
        attrValueService.remove(queryWrapper);
        return Result.ok();
    }

    /**
     * Delete an attribute value (element) by its ID.
     *
     * @param id the ID of the attribute value to be deleted
     * @return a Result indicating success of the deletion operation
     */
    @Operation(summary = "Delete an attribute value (element) by ID")
    @DeleteMapping("value/deleteById")
    public Result removeAttrValueById(@RequestParam Long id) {
        attrValueService.removeById(id);
        return Result.ok();
    }

}
