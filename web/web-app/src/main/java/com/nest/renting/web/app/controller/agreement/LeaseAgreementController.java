package com.nest.renting.web.app.controller.agreement;

import com.nest.renting.model.entity.LeaseAgreement;
import com.nest.renting.model.enums.LeaseStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import com.nest.renting.common.result.Result;

@RestController
@RequestMapping("/app/agreement")
@Tag(name = "Lease Information")
public class LeaseAgreementController {

    @Operation(summary = "Get a list of basic information about individual leases")
    @GetMapping("/listItem")
    public Result listItem() {
        return Result.ok();
    }

    @Operation(summary = "Get lease details by id")
    @GetMapping("/getDetailById")
    public Result getDetailById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "Update the lease status based on the id", description = "To confirm the lease and terminate the lease early")
    @PostMapping("/updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam LeaseStatus leaseStatus) {
        return Result.ok();
    }

    @Operation(summary = "Save or update a lease", description = "For renewal")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody LeaseAgreement leaseAgreement) {
        return Result.ok();
    }

}