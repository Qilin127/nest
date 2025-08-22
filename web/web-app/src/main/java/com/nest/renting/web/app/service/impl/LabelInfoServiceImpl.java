package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.LabelInfo;
import com.nest.renting.web.app.mapper.LabelInfoMapper;
import com.nest.renting.web.app.service.LabelInfoService;
import org.springframework.stereotype.Service;

@Service
public class LabelInfoServiceImpl extends ServiceImpl<LabelInfoMapper, LabelInfo>
    implements LabelInfoService {

}




