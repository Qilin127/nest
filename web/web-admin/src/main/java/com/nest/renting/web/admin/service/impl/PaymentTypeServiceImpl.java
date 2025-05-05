package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.PaymentType;
import com.nest.renting.web.admin.mapper.PaymentTypeMapper;
import com.nest.renting.web.admin.service.PaymentTypeService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [payment_type(payment method table)]
*/
@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
    implements PaymentTypeService {

}




