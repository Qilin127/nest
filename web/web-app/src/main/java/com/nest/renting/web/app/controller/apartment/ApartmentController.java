package com.nest.renting.web.app.controller.apartment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nest.renting.common.result.Result;

@RestController
@Tag(name = "Apartment Information")
@RequestMapping("/app/apartment")
public class ApartmentController {

    @Operation(summary = "Get apartment information by id")
    @GetMapping("/getDetailById")
    public Result getDetailById(@RequestParam Long id) {
        return Result.ok();
    }

}
