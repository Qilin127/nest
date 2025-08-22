package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.CityInfo;
import com.nest.renting.web.app.mapper.CityInfoMapper;
import com.nest.renting.web.app.service.CityInfoService;
import org.springframework.stereotype.Service;

@Service
public class CityInfoServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo>
    implements CityInfoService {

}




