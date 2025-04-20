package com.nest.renting.web.admin.controller.apartment;

import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.AttrKey;
import com.nest.renting.model.entity.AttrValue;
import com.nest.renting.web.admin.vo.attr.AttrKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Room attribute management")
@RestController
@RequestMapping("/admin/attr")
public class AttrController {
    @Operation(summary = "Add or update attribute names")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateAttrKey(@RequestBody AttrKey attrKey) {
        return Result.ok();
    }

    @Operation(summary = "Add or update attribute values")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateAttrValue(@RequestBody AttrValue attrValue) {
        return Result.ok();
    }

    @Operation(summary = "Retrieve the full list of attribute names and values")
    @GetMapping("list")
    public Result<List<AttrKeyVo>> listAttrInfo() {
        return Result.ok();
    }

    @Operation(summary = "Delete an attribute name (category) by ID")
    @DeleteMapping("key/deleteById")
    public Result removeAttrKeyById(@RequestParam Long attrKeyId) {
        return Result.ok();
    }

    @Operation(summary = "Delete an attribute value (element) by ID")
    @DeleteMapping("value/deleteById")
    public Result removeAttrValueById(@RequestParam Long id) {
        return Result.ok();
    }

}
