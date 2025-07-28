package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.SystemPost;
import com.nest.renting.model.entity.SystemUser;
import com.nest.renting.web.admin.mapper.SystemPostMapper;
import com.nest.renting.web.admin.mapper.SystemUserMapper;
import com.nest.renting.web.admin.service.SystemUserService;

import com.nest.renting.web.admin.vo.system.user.SystemUserItemVo;
import com.nest.renting.web.admin.vo.system.user.SystemUserQueryVo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description The implementation of the database operation Service for the table [system_user(Employee Information table)]
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements SystemUserService {

    @Resource
    private SystemUserMapper systemUserMapper;
    @Resource
    private SystemPostMapper systemPostMapper;

    @Override
    public IPage<SystemUserItemVo> pageSystemUserByQuery(IPage<SystemUser> page, SystemUserQueryVo queryVo) {
        return systemUserMapper.pageSystemUser(page, queryVo);
    }

    @Override
    public SystemUserItemVo getSystemUserById(Long id) {
        SystemUser systemUser = systemUserMapper.selectById(id);

        SystemPost systemPost = systemPostMapper.selectById(systemUser.getPostId());

        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
        BeanUtils.copyProperties(systemPost, systemUserItemVo);
        systemUserItemVo.setPostName(systemUserItemVo.getPostName());

        return systemUserItemVo;
    }

}
