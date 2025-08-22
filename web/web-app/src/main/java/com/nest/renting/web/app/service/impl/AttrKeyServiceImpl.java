package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.AttrKey;
import com.nest.renting.web.app.mapper.AttrKeyMapper;
import com.nest.renting.web.app.service.AttrKeyService;
import org.springframework.stereotype.Service;

@Service
public class AttrKeyServiceImpl extends ServiceImpl<AttrKeyMapper, AttrKey>
    implements AttrKeyService {

}




