package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.CityInfo;
import com.nest.renting.web.app.mapper.CityInfoMapper;
import com.nest.renting.web.app.service.CityInfoService;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link CityInfoService}.
 *
 * Provides database operations for the {@code city_info} table
 * using MyBatis-Plus {@link ServiceImpl}.
 *
 * @author Yuze Wang
 * @since 2025-08-22
 */
@Service
public class CityInfoServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo>
        implements CityInfoService {

}




