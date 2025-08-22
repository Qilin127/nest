package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.ApartmentFeeValue;
import com.nest.renting.web.app.mapper.ApartmentFeeValueMapper;
import com.nest.renting.web.app.service.ApartmentFeeValueService;
import org.springframework.stereotype.Service;

@Service
public class ApartmentFeeValueServiceImpl extends ServiceImpl<ApartmentFeeValueMapper, ApartmentFeeValue>
    implements ApartmentFeeValueService {
}




