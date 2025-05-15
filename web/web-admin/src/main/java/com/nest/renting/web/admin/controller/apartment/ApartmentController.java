package com.nest.renting.web.admin.controller.apartment;

import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.model.enums.ReleaseStatus;
import com.nest.renting.web.admin.service.ApartmentInfoService;
import com.nest.renting.web.admin.vo.apartment.ApartmentDetailVo;
import com.nest.renting.web.admin.vo.apartment.ApartmentItemVo;
import com.nest.renting.web.admin.vo.apartment.ApartmentQueryVo;
import com.nest.renting.web.admin.vo.apartment.ApartmentSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公寓信息管理 —— 公寓管理
 */
@Tag(name = "Apartment information management")
@RestController
@RequestMapping("/admin/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentInfoService apartmentInfoService;

    @Operation(summary = "Save or update apartment information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ApartmentSubmitVo apartmentSubmitVo) {
        // The saveOrUpdate of this service (provided by mybatis) can only manage the ApartmentInfo type and not the VO type.
        // Need to create the service yourself
        apartmentInfoService.saveOrUpdateApartment(apartmentSubmitVo);
        return Result.ok();
    }

    @Operation(summary = "Retrieve a paginated list of apartments based on filter conditions")
    @GetMapping("pageItem")
    public Result<IPage<ApartmentItemVo>> pageItem(@RequestParam long current, @RequestParam long size, ApartmentQueryVo queryVo) {
        return Result.ok();
    }

    /**
     * 用于公寓管理——修改公寓页面，用作修改回显
     */
    @Operation(summary = "Get detailed apartment information by ID")
    @GetMapping("getDetailById")
    public Result<ApartmentDetailVo> getDetailById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "Delete apartment information by ID")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "Update the apartment’s release status by ID")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(@RequestParam Long id, @RequestParam ReleaseStatus status) {
        return Result.ok();
    }

    @Operation(summary = "Retrieve a list of apartments by district ID")
    @GetMapping("listInfoByDistrictId")
    public Result<List<ApartmentInfo>> listInfoByDistrictId(@RequestParam Long id) {
        return Result.ok();
    }
}














