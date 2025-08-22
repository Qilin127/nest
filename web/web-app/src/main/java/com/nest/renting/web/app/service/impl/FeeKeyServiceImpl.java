package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.FeeKey;
import com.nest.renting.web.app.mapper.FeeKeyMapper;
import com.nest.renting.web.app.service.FeeKeyService;
import org.springframework.stereotype.Service;

@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService {

}




