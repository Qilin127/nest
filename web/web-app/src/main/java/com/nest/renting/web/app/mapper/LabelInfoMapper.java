package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.LabelInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {
    List<LabelInfo> selectListByApartmentId(Long apartmentId);

}




