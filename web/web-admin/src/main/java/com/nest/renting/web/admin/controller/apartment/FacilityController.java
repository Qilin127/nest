package com.nest.renting.web.admin.controller.apartment;

import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.FacilityInfo;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.admin.service.FacilityInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Facility management")
@RestController
@RequestMapping("/admin/facility")
public class FacilityController {

    @Autowired
    private FacilityInfoService facilityInfoService;

    @Operation(summary = "Retrieve the list of facilities by type")
    @GetMapping("list")
    public Result<List<FacilityInfo>> listFacility(@RequestParam(required = false) ItemType type) {
        return Result.ok();
    }

    @Operation(summary = "Add or update facility information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody FacilityInfo facilityInfo) {
        return Result.ok();
    }

    @Operation(summary = "Delete facility information by ID")
    @DeleteMapping("deleteById")
    public Result removeFacilityById(@RequestParam Long id) {
        return Result.ok();
    }

}
