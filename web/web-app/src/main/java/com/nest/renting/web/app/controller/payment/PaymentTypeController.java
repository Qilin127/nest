package com.nest.renting.web.app.controller.payment;

import com.nest.renting.common.result.Result;
import com.nest.renting.model.entity.PaymentType;
import com.nest.renting.web.app.service.PaymentTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller for managing payment types in the application.
 * <p>
 * Provides endpoints to fetch available payment types by room ID
 * or retrieve all payment types.
 * </p>
 *
 * @author Yuze Wang
 * @since 2025-09-15
 */
@Tag(name = "Payment Type API")
@RestController
@RequestMapping("/app/payment")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    /**
     * Get available payment types for a specific room.
     *
     * @param id the ID of the room
     * @return Result containing a list of available payment types
     */
    @Operation(summary = "Get available payment types by room ID")
    @GetMapping("listByRoomId")
    public Result<List<PaymentType>> list(@RequestParam Long id) {
        List<PaymentType> result = paymentTypeService.listByRoomId(id);
        return Result.ok(result);
    }

    /**
     * Get all payment types in the system.
     *
     * @return Result containing a list of all payment types
     */
    @Operation(summary = "Get all payment types")
    @GetMapping("list")
    public Result<List<PaymentType>> list() {
        List<PaymentType> list = paymentTypeService.list();
        return Result.ok(list);
    }
}

