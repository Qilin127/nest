package com.nest.renting.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.model.entity.PaymentType;

import java.util.List;

/**
 * @author Yuze Wang
 * @description Service for database operations on the table 【payment_type (Payment Type Table)】
 * @createDate 2025-09-15
 */
public interface PaymentTypeService extends IService<PaymentType> {
    List<PaymentType> listByRoomId(Long id);
}