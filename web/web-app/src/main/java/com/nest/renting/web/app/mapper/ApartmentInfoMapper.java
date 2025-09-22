package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.ApartmentInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    ApartmentInfo selectApartmentById(Long apartmentId);
}




