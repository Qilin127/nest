package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.DistrictInfo;
import com.nest.renting.web.app.mapper.DistrictInfoMapper;
import com.nest.renting.web.app.service.DistrictInfoService;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link DistrictInfoService}.
 *
 * Provides database operations for the {@code district_info} table
 * using MyBatis-Plus {@link ServiceImpl}.
 *
 * @author Yuze Wang
 * @since 2025-08-22
 */
@Service
public class DistrictInfoServiceImpl extends ServiceImpl<DistrictInfoMapper, DistrictInfo>
        implements DistrictInfoService {

}
