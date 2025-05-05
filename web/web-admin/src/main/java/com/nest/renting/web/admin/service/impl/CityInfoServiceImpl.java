package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.CityInfo;
import com.nest.renting.web.admin.mapper.CityInfoMapper;
import com.nest.renting.web.admin.service.CityInfoService;
import org.springframework.stereotype.Service;

/**
* @description The database operation Service implementation for the table [city info]
*/
@Service
public class CityInfoServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo>
    implements CityInfoService {

}




