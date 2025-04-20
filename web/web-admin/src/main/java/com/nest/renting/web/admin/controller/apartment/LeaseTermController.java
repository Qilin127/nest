package com.nest.renting.web.admin.controller.apartment;


import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.LeaseTerm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Lease Term Management")
@RequestMapping("/admin/term")
@RestController
public class LeaseTermController {

    @GetMapping("list")
    @Operation(summary = "Search All lease lists")
    public Result<List<LeaseTerm>> listLeaseTerm() {
        return Result.ok();
    }

    @PostMapping("saveOrUpdate")
    @Operation(summary = "Save or update lease term information")
    public Result saveOrUpdate(@RequestBody LeaseTerm leaseTerm) {
        return Result.ok();
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "Delete lease term by ID")
    public Result deleteLeaseTermById(@RequestParam Long id) {
        return Result.ok();
    }
}
