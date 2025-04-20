package com.nest.renting.web.admin.controller.apartment;


import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.PaymentType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Payment method management")
@RequestMapping("/admin/payment")
@RestController
public class PaymentTypeController {

    @Operation(summary = "Retrieve the full list of payment methods")
    @GetMapping("list")
    public Result<List<PaymentType>> listPaymentType() {
        return Result.ok();
    }

    @Operation(summary = "Save or update a payment method")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdatePaymentType(@RequestBody PaymentType paymentType) {
        return Result.ok();
    }

    @Operation(summary = "Delete a payment method by ID")
    @DeleteMapping("deleteById")
    public Result deletePaymentById(@RequestParam Long id) {
        return Result.ok();
    }

}















