package com.nest.renting.web.app.controller.agreement;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.nest.renting.common.login.LoginUserHolder;
import com.nest.renting.model.entity.LeaseAgreement;
import com.nest.renting.model.enums.LeaseStatus;
import com.nest.renting.web.app.service.LeaseAgreementService;
import com.nest.renting.web.app.vo.agreement.AgreementDetailVo;
import com.nest.renting.web.app.vo.agreement.AgreementItemVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nest.renting.common.result.Result;
import java.util.List;

@RestController
@RequestMapping("/app/agreement")
@Tag(name = "Lease Information")
public class LeaseAgreementController {

    @Autowired
    LeaseAgreementService service;

    @Operation(summary = "Get a list of basic information about individual leases")
    @GetMapping("/listItem")
    public Result<List<AgreementItemVo>> listItem() {
        List<AgreementItemVo> list = service.listAgreementItemByPhone(LoginUserHolder.getLoginUser().getUsername());
        return Result.ok(list);
    }

    @Operation(summary = "Get lease details by id")
    @GetMapping("/getDetailById")
    public Result<AgreementDetailVo> getDetailById(@RequestParam Long id) {
        AgreementDetailVo agreementDetailVo = service.getAgreementDetailById(id);
        return Result.ok(agreementDetailVo);
    }

    @Operation(summary = "Update the lease status based on the id", description = "To confirm the lease and terminate the lease early")
    @PostMapping("/updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam LeaseStatus leaseStatus) {
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(LeaseAgreement::getId, id);
        updateWrapper.set(LeaseAgreement::getStatus, leaseStatus);
        service.update(updateWrapper);
        return Result.ok();
    }

    @Operation(summary = "Save or update a lease", description = "For renewal")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody LeaseAgreement leaseAgreement) {
        service.saveOrUpdate(leaseAgreement);
        return Result.ok();
    }

}