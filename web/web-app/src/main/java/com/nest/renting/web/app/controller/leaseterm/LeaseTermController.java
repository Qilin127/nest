package com.nest.renting.web.app.controller.leaseterm;

import com.nest.renting.model.entity.LeaseTerm;
import com.nest.renting.web.app.service.LeaseTermService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nest.renting.common.result.Result;

import java.util.List;


@RestController
@RequestMapping("/app/term/")
@Tag(name = "Lease Information")
public class LeaseTermController {

    @Autowired
    LeaseTermService service;

    @GetMapping("listByRoomId")
    @Operation(summary = "Get optional rental period list based on room ID")
    public Result<List<LeaseTerm>> list(@RequestParam Long id) {
        List<LeaseTerm> list = service.listByRoomId(id);
        return Result.ok(list);
    }
}
