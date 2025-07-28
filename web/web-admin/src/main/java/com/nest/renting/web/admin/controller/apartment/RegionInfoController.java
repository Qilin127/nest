package com.nest.renting.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.CityInfo;
import com.nest.renting.model.entity.DistrictInfo;
import com.nest.renting.model.entity.ProvinceInfo;
import com.nest.renting.web.admin.service.CityInfoService;
import com.nest.renting.web.admin.service.DistrictInfoService;
import com.nest.renting.web.admin.service.ProvinceInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for managing region information including provinces, cities, and districts.
 */
@Tag(name = "Region information management")
@RestController
@RequestMapping("/admin/region")
public class RegionInfoController {
    @Autowired
    private ProvinceInfoService provinceInfoService;
    @Autowired
    private CityInfoService cityInfoService;
    @Autowired
    private DistrictInfoService districtInfoService;

    /**
     * Retrieves the list of all provinces.
     *
     * @return Result containing a list of ProvinceInfo objects.
     */
    @Operation(summary = "Retrieve the list of state")
    @GetMapping("province/list")
    public Result<List<ProvinceInfo>> listProvince() {
        List<ProvinceInfo> list = provinceInfoService.list();
        return Result.ok(list);
    }

    /**
     * Retrieves the list of cities by the given province ID.
     *
     * @param id the ID of the province
     * @return Result containing a list of CityInfo objects belonging to the specified province.
     */
    @Operation(summary = "Retrieve the list of cities by state ID")
    @GetMapping("city/listByProvinceId")
    public Result<List<CityInfo>> listCityInfoByProvinceId(@RequestParam Long id) {
        LambdaQueryWrapper<CityInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CityInfo::getProvinceId, id);
        List<CityInfo> list = cityInfoService.list(lambdaQueryWrapper);
        return Result.ok(list);
    }

    /**
     * Retrieves the list of districts by the given city ID.
     *
     * @param id the ID of the city
     * @return Result containing a list of DistrictInfo objects belonging to the specified city.
     */
    @GetMapping("district/listByCityId")
    @Operation(summary = "Retrieve the list of districts by city ID")
    public Result<List<DistrictInfo>> listDistrictInfoByCityId(@RequestParam Long id) {
        LambdaQueryWrapper<DistrictInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(DistrictInfo::getCityId, id);
        List<DistrictInfo> list = districtInfoService.list(lambdaQueryWrapper);
        return Result.ok(list);
    }

}
