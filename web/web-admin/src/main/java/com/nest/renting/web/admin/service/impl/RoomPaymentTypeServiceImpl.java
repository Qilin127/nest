package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.RoomPaymentType;
import com.nest.renting.web.admin.mapper.RoomPaymentTypeMapper;
import com.nest.renting.web.admin.service.RoomPaymentTypeService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [room_payment_type(room & Payment Method association table)]
*/
@Service
public class RoomPaymentTypeServiceImpl extends ServiceImpl<RoomPaymentTypeMapper, RoomPaymentType>
    implements RoomPaymentTypeService {

}




