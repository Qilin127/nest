package com.nest.renting.web.admin.controller.apartment;

import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.CityInfo;
import com.nest.renting.model.entity.DistrictInfo;
import com.nest.renting.model.entity.ProvinceInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Region information management")
@RestController
@RequestMapping("/admin/region")
public class RegionInfoController {
    @Operation(summary = "Retrieve the list of provinces")
    @GetMapping("province/list")
    public Result<List<ProvinceInfo>> listProvince() {
        return Result.ok();
    }

    @Operation(summary = "Retrieve the list of cities by province ID")
    @GetMapping("city/listByProvinceId")
    public Result<List<CityInfo>> listCityInfoByProvinceId(@RequestParam Long id) {
        return Result.ok();
    }

    @GetMapping("district/listByCityId")
    @Operation(summary = "Retrieve the list of districts by city ID")
    public Result<List<DistrictInfo>> listDistrictInfoByCityId(@RequestParam Long id) {
        return Result.ok();
    }

}
