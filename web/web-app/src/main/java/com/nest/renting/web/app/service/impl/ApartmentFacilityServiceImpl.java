package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.ApartmentFacility;
import com.nest.renting.web.app.mapper.ApartmentFacilityMapper;
import com.nest.renting.web.app.service.ApartmentFacilityService;
import org.springframework.stereotype.Service;

@Service
public class ApartmentFacilityServiceImpl extends ServiceImpl<ApartmentFacilityMapper, ApartmentFacility>
    implements ApartmentFacilityService {
}




