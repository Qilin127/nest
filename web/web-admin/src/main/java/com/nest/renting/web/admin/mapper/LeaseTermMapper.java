package com.nest.renting.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.LeaseTerm;

import java.util.List;

/**
* @description The database operation Mapper for the table [lease term]
*/
public interface LeaseTermMapper extends BaseMapper<LeaseTerm> {
    List<LeaseTerm> selectListByRoomId(Long id);
}




