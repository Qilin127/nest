package com.nest.renting.web.admin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.AttrKey;
import com.nest.renting.web.admin.mapper.AttrKeyMapper;
import com.nest.renting.web.admin.service.AttrKeyService;
import org.springframework.stereotype.Service;

/**
* @author liubo
* @description The implementation of the database operation Service for the table [attr_key(basic attribute table of the room)]
* @createDate 2023-07-24 15:48:00
*/
@Service
public class AttrKeyServiceImpl extends ServiceImpl<AttrKeyMapper, AttrKey>
    implements AttrKeyService {

}




