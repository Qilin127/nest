package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.FeeKey;
import com.nest.renting.web.admin.mapper.FeeKeyMapper;
import com.nest.renting.web.admin.service.FeeKeyService;
import com.nest.renting.web.admin.vo.fee.FeeKeyVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description The implementation of the database operation Service for the table [fee_key(Miscellaneous Fee Name Table)]
*/
@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
        implements FeeKeyService {

    @Autowired
    private FeeKeyMapper feeKeyMapper;

    @Override
    public List<FeeKeyVo> feeInfoList() {
        return feeKeyMapper.feeInfoList();
    }
}




