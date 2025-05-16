package com.nest.renting.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.FeeValue;
import com.nest.renting.web.admin.vo.fee.FeeValueVo;

import java.util.List;

/**
* @description The database operation Mapper for the table [fee_value(Miscellaneous cost Value table)]
* @Entity com.atguigu.lease.model.FeeValue
*/
public interface FeeValueMapper extends BaseMapper<FeeValue> {

    List<FeeValueVo> selectListByIApartmentId(Long id);
}




