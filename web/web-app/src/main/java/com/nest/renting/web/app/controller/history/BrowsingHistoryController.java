package com.nest.renting.web.app.controller.history;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nest.renting.common.result.Result;

@RestController
@Tag(name = "Browsing history management")
@RequestMapping("/app/history")
public class BrowsingHistoryController {

    @Operation(summary = "Get browsing history")
    @GetMapping("/pageItem")
    private Result page(@RequestParam long current, @RequestParam long size) {
        return Result.ok();
    }

}
