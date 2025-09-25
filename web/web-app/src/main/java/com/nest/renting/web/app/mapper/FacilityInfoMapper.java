package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.FacilityInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {
    List<FacilityInfo> selectListByApartmentId(Long id);

}




