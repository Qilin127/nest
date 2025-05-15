package com.nest.renting.web.admin.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nest.renting.common.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.UserInfo;
import com.nest.renting.model.enums.BaseStatus;
import com.nest.renting.web.admin.service.UserInfoService;
import com.nest.renting.web.admin.vo.user.UserInfoQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Information Management")
@RestController
@RequestMapping("/admin/user")
public class UserInfoController {

    @Autowired
    private UserInfoService service;

    @Operation(summary = "Paginated Query of User Information")
    @GetMapping("page")
    public Result<IPage<UserInfo>> pageUserInfo(@RequestParam long current, @RequestParam long size, UserInfoQueryVo queryVo) {
        IPage<UserInfo> page = new Page<>(current, size);
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(queryVo.getPhone() != null, UserInfo::getPhone, queryVo.getPhone());
        queryWrapper.eq(queryVo.getStatus() != null, UserInfo::getStatus, queryVo.getStatus());
        IPage<UserInfo> list = service.page(page, queryWrapper);
        return Result.ok(list);
    }

    @Operation(summary = "Update Account Status by User ID")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam BaseStatus status) {

        LambdaUpdateWrapper<UserInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(UserInfo::getId, id);
        updateWrapper.set(UserInfo::getStatus, status);
        service.update(updateWrapper);
        return Result.ok();
    }


}
