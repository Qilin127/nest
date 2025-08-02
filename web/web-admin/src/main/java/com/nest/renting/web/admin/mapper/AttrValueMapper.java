package com.nest.renting.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.AttrValue;
import com.nest.renting.web.admin.vo.attr.AttrValueVo;

import java.util.List;

/**
* @description The database operation Mapper for the table [attr_value(room Basic Attribute Value table)]
* @Entity com.atguigu.lease.model.AttrValue
*/
public interface AttrValueMapper extends BaseMapper<AttrValue> {
    List<AttrValueVo> selectListByRoomId(Long id);

}




