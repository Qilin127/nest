package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.PaymentType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yuze Wang
 * @description Mapper for database operations on the table 【payment_type (Payment Type Table)】
 * @createDate 2025-09-15
 * @Entity com.nest.renting.model.entity.PaymentType
 */
@Repository
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {

    List<PaymentType> selectListByRoomId(Long id);

    PaymentType selectPaymentTypeById(Long id);
}



