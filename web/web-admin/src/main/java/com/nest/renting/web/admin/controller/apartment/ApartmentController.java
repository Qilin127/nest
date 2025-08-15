package com.nest.renting.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
 * Controller for managing apartment information.
 */
@Tag(name = "Apartment information management")
@RestController
@RequestMapping("/admin/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentInfoService apartmentInfoService;

    /**
     * Save or update apartment information.
     *
     * @param apartmentSubmitVo the apartment data transfer object containing apartment details
     * @return a Result indicating success or failure
     */
    @Operation(summary = "Save or update apartment information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ApartmentSubmitVo apartmentSubmitVo) {
        // The saveOrUpdate of this service (provided by mybatis) can only manage the ApartmentInfo type and not the VO type.
        // Need to create the service yourself
        apartmentInfoService.saveOrUpdateApartment(apartmentSubmitVo);
        return Result.ok();
    }

    /**
     * Retrieve a paginated list of apartments based on filter conditions.
     *
     * @param current the current page number
     * @param size the number of items per page
     * @param queryVo the filter criteria encapsulated in ApartmentQueryVo
     * @return a paginated Result containing a list of ApartmentItemVo
     */
    @Operation(summary = "Retrieve a paginated list of apartments based on filter conditions")
    @GetMapping("pageItem")
    public Result<IPage<ApartmentItemVo>> pageItem(@RequestParam long current, @RequestParam long size, ApartmentQueryVo queryVo) {
        Page<ApartmentItemVo> apartmentItemVoPage = new Page<>(current, size);
        IPage<ApartmentItemVo> apartmentItemVoIPage = apartmentInfoService.pageItem(apartmentItemVoPage, queryVo);
        return Result.ok(apartmentItemVoIPage);
    }

    /**
     * For apartment management - Modify the apartment page and serve as a modification echo
     */
    @Operation(summary = "Get detailed apartment information by ID")
    @GetMapping("getDetailById")
    public Result<ApartmentDetailVo> getDetailById(@RequestParam Long id) {
        ApartmentDetailVo apartmentDetailVo = apartmentInfoService.getDetailById(id);
        return Result.ok(apartmentDetailVo);
    }


    /**
     * Delete apartment information by ID.
     *
     * @param id the apartment ID to delete
     * @return a Result indicating success or failure
     */
    @Operation(summary = "Delete apartment information by ID")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        apartmentInfoService.removeDetailById(id);
        return Result.ok();
    }

    /**
     * Update the apartment’s release status by ID.
     *
     * @param id the apartment ID
     * @param status the new release status
     * @return a Result indicating success or failure
     */
    @Operation(summary = "Update the apartment’s release status by ID")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(@RequestParam Long id, @RequestParam ReleaseStatus status) {
        LambdaUpdateWrapper<ApartmentInfo> infoLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        infoLambdaUpdateWrapper.eq(ApartmentInfo::getId, id).set(ApartmentInfo::getIsRelease, status);
        apartmentInfoService.update(infoLambdaUpdateWrapper);
        return Result.ok();
    }

    /**
     * Retrieve a list of apartments by district ID.
     *
     * @param id the district ID
     * @return a Result containing a list of ApartmentInfo objects in the specified district
     */
    @Operation(summary = "Retrieve a list of apartments by district ID")
    @GetMapping("listInfoByDistrictId")
    public Result<List<ApartmentInfo>> listInfoByDistrictId(@RequestParam Long id) {
        LambdaQueryWrapper<ApartmentInfo> apartmentInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        apartmentInfoLambdaQueryWrapper.eq(ApartmentInfo::getDistrictId, id);
        List<ApartmentInfo> list = apartmentInfoService.list(apartmentInfoLambdaQueryWrapper);
        return Result.ok(list);
    }
}














