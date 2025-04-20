package com.nest.renting.web.admin.controller.lease;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nest.renting.common.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.LeaseAgreement;
import com.nest.renting.model.enums.LeaseStatus;
import com.nest.renting.web.admin.service.LeaseAgreementService;
import com.nest.renting.web.admin.vo.agreement.AgreementQueryVo;
import com.nest.renting.web.admin.vo.agreement.AgreementVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Lease agreement management")
@RestController
@RequestMapping("/admin/agreement")
public class LeaseAgreementController {

    @Autowired
    private LeaseAgreementService leaseAgreementService;

    @Operation(summary = "Save or update lease agreement information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody LeaseAgreement leaseAgreement) {
        // 不是VO类型，直接调用通用方法
        leaseAgreementService.saveOrUpdate(leaseAgreement);
        return Result.ok();
    }

    @Operation(summary = "Retrieve a paginated list of lease agreements based on conditions")
    @GetMapping("page")
    public Result<IPage<AgreementVo>> page(@RequestParam long current, @RequestParam long size, AgreementQueryVo queryVo) {
        IPage<AgreementVo> agreementVoIPage = new Page<>(current, size);
        IPage<AgreementVo> result = leaseAgreementService.pageAgreement(agreementVoIPage, queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "Get lease agreement details by ID")
    @GetMapping(name = "getById")
    public Result<AgreementVo> getById(@RequestParam Long id) {
        AgreementVo agreementVo = leaseAgreementService.getAgreementById(id);
        return Result.ok(agreementVo);
    }

    @Operation(summary = "Delete lease agreement by ID")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        leaseAgreementService.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "Update lease agreement status by ID")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam LeaseStatus status) {
        LambdaUpdateWrapper<LeaseAgreement> leaseAgreementLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        leaseAgreementLambdaUpdateWrapper.eq(LeaseAgreement::getId, id);
        leaseAgreementLambdaUpdateWrapper.set(LeaseAgreement::getStatus, status);
        leaseAgreementService.update(leaseAgreementLambdaUpdateWrapper);
        return Result.ok();
    }

}

