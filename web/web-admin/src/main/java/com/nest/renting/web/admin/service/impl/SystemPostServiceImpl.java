package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.SystemPost;
import com.nest.renting.web.admin.mapper.SystemPostMapper;
import com.nest.renting.web.admin.service.SystemPostService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [system_post(Job Information Table)]
*/
@Service
public class SystemPostServiceImpl extends ServiceImpl<SystemPostMapper, SystemPost>
    implements SystemPostService {

}




