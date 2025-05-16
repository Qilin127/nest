package com.nest.renting.web.admin.service;

import com.nest.renting.model.entity.FeeKey;
import com.nest.renting.web.admin.vo.fee.FeeKeyVo;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @description The database operation Service for the table [fee_key(Miscellaneous fee Name Table)]
*/
public interface FeeKeyService extends IService<FeeKey> {
    List<FeeKeyVo> listFeeInfo();

}
