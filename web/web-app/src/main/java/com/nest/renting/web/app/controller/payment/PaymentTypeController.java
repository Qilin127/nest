package com.nest.renting.web.app.controller.payment;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nest.renting.common.result.Result;


@Tag(name = "Payment method interface")
@RestController
@RequestMapping("/app/payment")
public class PaymentTypeController {

    @Operation(summary = "Get a list of available payment methods based on the room ID")
    @GetMapping("/listByRoomId")
    public Result list(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "Get a list of all payment methods")
    @GetMapping("/list")
    public Result list() {
        return Result.ok();
    }
}
