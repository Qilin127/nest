package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.PaymentType;
import com.nest.renting.web.app.mapper.PaymentTypeMapper;
import com.nest.renting.web.app.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuze Wang
 * @description Service implementation for database operations on the table 【payment_type(Payment Type Table)】
 * @createDate 2025-09-15
 */
@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
        implements PaymentTypeService {

    @Autowired
    private PaymentTypeMapper paymentTypeMapper;

    /**
     * Get available payment types by room ID
     * @param id Room ID
     * @return List of PaymentTypes
     */
    @Override
    public List<PaymentType> listByRoomId(Long id) {
        return paymentTypeMapper.selectListByRoomId(id);
    }
}




