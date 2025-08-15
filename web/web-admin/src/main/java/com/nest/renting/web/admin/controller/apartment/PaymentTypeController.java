package com.nest.renting.web.admin.controller.apartment;


import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.PaymentType;
import com.nest.renting.web.admin.service.PaymentTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Payment Method Management
 */
@Tag(name = "Payment method management")
@RequestMapping("/admin/payment")
@RestController
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    /**
     * Retrieve the full list of payment methods.
     *
     * @return Result containing a list of all PaymentType entities.
     */
    @Operation(summary = "Retrieve the full list of payment methods")
    @GetMapping("list")
    public Result<List<PaymentType>> listPaymentType() {
        List<PaymentType> list = paymentTypeService.list();
        return Result.ok(list);
    }

    /**
     * Save or update a payment method.
     *
     * @param paymentType The PaymentType object containing the payment method data to be saved or updated.
     * @return A Result object indicating the success of the operation.
     */
    @Operation(summary = "Save or update a payment method")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdatePaymentType(@RequestBody PaymentType paymentType) {
        paymentTypeService.saveOrUpdate(paymentType);
        return Result.ok();
    }

    /**
     * Delete a payment method by ID.
     *
     * @param id The ID of the payment method to be deleted.
     * @return A Result object indicating the success of the operation.
     */
    @Operation(summary = "Delete a payment method by ID")
    @DeleteMapping("deleteById")
    public Result deletePaymentById(@RequestParam Long id) {
        paymentTypeService.removeById(id); // MyBatis-Plus will automatically perform logical deletion due to the @TableLogic annotation
        return Result.ok(); 
    }

}















