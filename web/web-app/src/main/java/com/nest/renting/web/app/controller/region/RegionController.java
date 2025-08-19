package com.nest.renting.web.app.controller.region;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nest.renting.common.result.Result;


@Tag(name = "Regional Information")
@RestController
@RequestMapping("/app/region")
public class RegionController {

    @Operation(summary="Query province information list")
    @GetMapping("/province/list")
    public Result listProvince(){
        return Result.ok();
    }

    @Operation(summary="Query city information list based on province ID")
    @GetMapping("/city/listByProvinceId")
    public Result listCityInfoByProvinceId(@RequestParam Long id){
        return Result.ok();
    }

    @GetMapping("district/listByCityId")
    @Operation(summary="Query district and county information based on city ID")
    public Result listDistrictInfoByCityId(@RequestParam Long id){
        return Result.ok();
    }
}
