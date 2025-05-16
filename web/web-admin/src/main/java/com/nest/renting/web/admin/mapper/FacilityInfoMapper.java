package com.nest.renting.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.FacilityInfo;

import java.util.List;

/**
* @description The database operation Mapper for the table [facility_info(accompanying information table)]
* @Entity com.atguigu.lease.model.FacilityInfo
*/
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

    List<FacilityInfo> selectListByIApartmentId(Long id);
}




