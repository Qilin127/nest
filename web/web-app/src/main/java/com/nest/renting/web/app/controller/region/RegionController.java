package com.nest.renting.web.app.controller.region;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.CityInfo;
import com.nest.renting.model.entity.DistrictInfo;
import com.nest.renting.model.entity.ProvinceInfo;
import com.nest.renting.web.app.service.CityInfoService;
import com.nest.renting.web.app.service.DistrictInfoService;
import com.nest.renting.web.app.service.ProvinceInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RegionController
 *
 * This controller provides APIs to retrieve region-related information,
 * including provinces, cities, and districts.
 *
 * <p>Main functions:</p>
 * <ul>
 *     <li>List all provinces</li>
 *     <li>List cities by province ID</li>
 *     <li>List districts by city ID</li>
 * </ul>
 *
 * @author Yuze Wang
 * @since 2025-08-24
 */
@Tag(name = "Region Information")
@RestController
@RequestMapping("/app/region")
public class RegionController {

    @Autowired
    private ProvinceInfoService provinceInfoService;

    @Autowired
    private CityInfoService cityInfoService;

    @Autowired
    private DistrictInfoService districtInfoService;

    /**
     * Retrieve all provinces.
     *
     * @return a list of {@link ProvinceInfo}
     */
    @Operation(summary = "Get the list of provinces")
    @GetMapping("province/list")
    public Result<List<ProvinceInfo>> listProvince() {
        List<ProvinceInfo> list = provinceInfoService.list();
        return Result.ok(list);
    }

    /**
     * Retrieve all cities under a specific province.
     *
     * @param id the province ID
     * @return a list of {@link CityInfo}
     */
    @Operation(summary = "Get the list of cities by province ID")
    @GetMapping("city/listByProvinceId")
    public Result<List<CityInfo>> listCityInfoByProvinceId(@RequestParam Long id) {
        LambdaQueryWrapper<CityInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CityInfo::getProvinceId, id);
        List<CityInfo> list = cityInfoService.list(queryWrapper);
        return Result.ok(list);
    }

    /**
     * Retrieve all districts under a specific city.
     *
     * @param id the city ID
     * @return a list of {@link DistrictInfo}
     */
    @Operation(summary = "Get the list of districts by city ID")
    @GetMapping("district/listByCityId")
    public Result<List<DistrictInfo>> listDistrictInfoByCityId(@RequestParam Long id) {
        LambdaQueryWrapper<DistrictInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DistrictInfo::getCityId, id);
        List<DistrictInfo> list = districtInfoService.list(queryWrapper);
        return Result.ok(list);
    }
}