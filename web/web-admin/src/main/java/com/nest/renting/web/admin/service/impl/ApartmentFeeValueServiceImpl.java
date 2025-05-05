package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.ApartmentFeeValue;
import com.nest.renting.web.admin.mapper.ApartmentFeeValueMapper;
import com.nest.renting.web.admin.service.ApartmentFeeValueService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [apartment_fee_value(Apartment & Miscellaneous Fee Association Table)]
*/
@Service
public class ApartmentFeeValueServiceImpl extends ServiceImpl<ApartmentFeeValueMapper, ApartmentFeeValue>
    implements ApartmentFeeValueService {

}




