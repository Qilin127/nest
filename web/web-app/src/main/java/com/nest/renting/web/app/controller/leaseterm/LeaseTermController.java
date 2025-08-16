package com.nest.renting.web.app.controller.leaseterm;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nest.renting.common.result.Result;


@RestController
@RequestMapping("/app/term/")
@Tag(name = "Lease Information")
public class LeaseTermController {

    @GetMapping("listByRoomId")
    @Operation(summary = "Get optional rental period list based on room ID")
    public Result list(@RequestParam Long id) {
        return Result.ok();
    }
}
