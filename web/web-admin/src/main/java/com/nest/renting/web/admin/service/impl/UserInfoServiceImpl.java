package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.UserInfo;
import com.nest.renting.web.admin.mapper.UserInfoMapper;
import com.nest.renting.web.admin.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [user_info(User Information Table)]
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

}




