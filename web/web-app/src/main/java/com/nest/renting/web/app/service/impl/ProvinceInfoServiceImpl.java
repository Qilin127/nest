package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.ProvinceInfo;
import com.nest.renting.web.app.mapper.ProvinceInfoMapper;
import com.nest.renting.web.app.service.ProvinceInfoService;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link ProvinceInfoService}.
 *
 * Provides database operations for the {@code province_info} table
 * using MyBatis-Plus {@link ServiceImpl}.
 *
 * @author Yuze Wang
 * @since 2025-08-22
 */
@Service
public class ProvinceInfoServiceImpl extends ServiceImpl<ProvinceInfoMapper, ProvinceInfo>
        implements ProvinceInfoService {

}
