package com.nest.renting.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
    private FacilityInfoService service;

    /**
     * Retrieves a list of supporting facilities filtered by type (optional).
     *
     * @param type Optional parameter specifying the type of facility to filter by.
     *             If null, all facility records will be returned.
     * @return A Result object containing the list of matching FacilityInfo entries.
     */
    @Operation(summary = "Retrieve the list of facilities by type")
    @GetMapping("list")
    public Result<List<FacilityInfo>> listFacility(@RequestParam(required = false) ItemType type) {
        LambdaQueryWrapper<FacilityInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(type != null, FacilityInfo::getType, type);
        List<FacilityInfo> list = service.list(queryWrapper);
        return Result.ok(list);
    }

    /**
     * Add or update facility information
     *
     * @param facilityInfo The FacilityInfo object containing data to be saved or updated
     * @return A Result object indicating the success of the operation
     */
    @Operation(summary = "Add or update facility information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody FacilityInfo facilityInfo) {
        service.saveOrUpdate(facilityInfo);
        return Result.ok();
    }

    /**
     * Delete facility information by ID
     *
     * @param id The ID of the facility to be deleted
     * @return A Result object indicating the success of the operation
     */
    @Operation(summary = "Delete facility information by ID")
    @DeleteMapping("deleteById")
    public Result removeFacilityById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }

}
