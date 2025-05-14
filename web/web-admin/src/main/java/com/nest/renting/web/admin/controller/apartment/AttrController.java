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


@Tag(name = "Room attribute management")
@RestController
@RequestMapping("/admin/attr")
public class AttrController {
    @Autowired
    private AttrKeyService attrKeyService;
    @Autowired
    private AttrValueService attrValueService;

    @Operation(summary = "Add or update attribute names")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateAttrKey(@RequestBody AttrKey attrKey) {
        attrKeyService.saveOrUpdate(attrKey);//Save or update attribute names
        return Result.ok();
    }

    @Operation(summary = "Add or update attribute values")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateAttrValue(@RequestBody AttrValue attrValue) {
        attrValueService.saveOrUpdate(attrValue);
        return Result.ok();
    }

    @Operation(summary = "Retrieve the full list of attribute names and values")
    @GetMapping("list")
    public Result<List<AttrKeyVo>> listAttrInfo() {
        List<AttrKeyVo> list = attrKeyService.listAttrInfo();//List<AttrKeyVo> is equivalent to: List<name, List<AttrValue>>
        return Result.ok();
    }

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

    @Operation(summary = "Delete an attribute value (element) by ID")
    @DeleteMapping("value/deleteById")
    public Result removeAttrValueById(@RequestParam Long id) {
        attrValueService.removeById(id);
        return Result.ok();
    }

}
