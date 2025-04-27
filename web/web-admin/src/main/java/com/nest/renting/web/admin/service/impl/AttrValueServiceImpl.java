package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.AttrValue;
import com.nest.renting.web.admin.mapper.AttrValueMapper;
import com.nest.renting.web.admin.service.AttrValueService;
import org.springframework.stereotype.Service;

/**
* @descriptionThe implementation of the database operation Service for the table [attr_value(Room Basic Attribute Value table)]
*/
@Service
public class AttrValueServiceImpl extends ServiceImpl<AttrValueMapper, AttrValue>
    implements AttrValueService {

}




