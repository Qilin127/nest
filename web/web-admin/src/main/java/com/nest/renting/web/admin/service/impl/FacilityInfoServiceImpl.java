package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.FacilityInfo;
import com.nest.renting.web.admin.mapper.FacilityInfoMapper;
import com.nest.renting.web.admin.service.FacilityInfoService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [facility_info(accompanying information table)]
*/
@Service
public class FacilityInfoServiceImpl extends ServiceImpl<FacilityInfoMapper, FacilityInfo>
    implements FacilityInfoService {

}




