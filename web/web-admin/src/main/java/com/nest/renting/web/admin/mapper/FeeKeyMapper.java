package com.nest.renting.web.admin.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.FeeKey;
import com.nest.renting.web.admin.vo.fee.FeeKeyVo;

/**
* @description The database operation Mapper for the table [fee_key(Miscellaneous fee Name Table)]
* @Entity com.atguigu.lease.model.FeeKey
*/
public interface FeeKeyMapper extends BaseMapper<FeeKey> {

 List<FeeKeyVo> feeInfoList();
}




