package com.nest.renting.web.admin.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.AttrKey;
import com.nest.renting.web.admin.vo.attr.AttrKeyVo;

/**
* @description The database operation Mapper for the table [attr_key(basic attribute table of the room)]
* @Entity com.atguigu.lease.model.AttrKey
*/
public interface AttrKeyMapper extends BaseMapper<AttrKey> {
    List<AttrKeyVo> listAttrInfo();

}




