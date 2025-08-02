package com.nest.renting.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.PaymentType;

import java.util.List;

/**
 * @description The database operation Mapper for the table [payment_type(payment method table)]
 * @Entity com.atguigu.lease.model.PaymentType
 */
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {
    List<PaymentType> selectListByRoomId(Long id);
}




