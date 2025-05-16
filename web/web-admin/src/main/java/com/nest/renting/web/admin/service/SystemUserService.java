package com.nest.renting.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.SystemUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.web.admin.vo.system.user.SystemUserItemVo;
import com.nest.renting.web.admin.vo.system.user.SystemUserQueryVo;

/**
* @description The database operation Service for the table [system_user(Employee information table)]
*/
public interface SystemUserService extends IService<SystemUser> {

    IPage<SystemUserItemVo> pageSystemUserByQuery(IPage<SystemUser> page, SystemUserQueryVo queryVo);

    SystemUserItemVo getSystemUserById(Long id);
}
