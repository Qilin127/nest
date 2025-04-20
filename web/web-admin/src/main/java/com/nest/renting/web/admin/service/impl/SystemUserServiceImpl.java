package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.SystemUser;
import com.nest.renting.web.admin.mapper.SystemUserMapper;
import com.nest.renting.web.admin.service.SystemUserService;

import org.springframework.stereotype.Service;

/**
 * @description The implementation of the database operation Service for the table [system_user(Employee Information table)]
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {

}




