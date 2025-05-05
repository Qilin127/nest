package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.LabelInfo;
import com.nest.renting.web.admin.mapper.LabelInfoMapper;
import com.nest.renting.web.admin.service.LabelInfoService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [label_info(Label Information Table)]
*/
@Service
public class LabelInfoServiceImpl extends ServiceImpl<LabelInfoMapper, LabelInfo>
    implements LabelInfoService {

}




