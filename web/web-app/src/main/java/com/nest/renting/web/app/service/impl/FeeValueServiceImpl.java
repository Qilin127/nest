package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.FeeValue;
import com.nest.renting.web.app.mapper.FeeValueMapper;
import com.nest.renting.web.app.service.FeeValueService;
import org.springframework.stereotype.Service;

@Service
public class FeeValueServiceImpl extends ServiceImpl<FeeValueMapper, FeeValue>
    implements FeeValueService {

}




