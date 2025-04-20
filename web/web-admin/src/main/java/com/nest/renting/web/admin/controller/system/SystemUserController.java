package com.nest.renting.web.admin.controller.system;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nest.renting.common.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.SystemUser;
import com.nest.renting.model.enums.BaseStatus;
import com.nest.renting.web.admin.service.SystemUserService;
import com.nest.renting.web.admin.vo.system.user.SystemUserItemVo;
import com.nest.renting.web.admin.vo.system.user.SystemUserQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Admin User Information Management")
@RestController
@RequestMapping("/admin/system/user")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    @Operation(summary = "Paginated Query of Admin User List Based on Conditions")
    @GetMapping("page")
    public Result<IPage<SystemUserItemVo>> page(@RequestParam long current, @RequestParam long size, SystemUserQueryVo queryVo) {
        IPage<SystemUserItemVo> systemUserItemVoIPage = new Page<>(current, size);
        IPage<SystemUserItemVo> result = systemUserService.pageSystemUser(systemUserItemVoIPage, queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "Retrieve Admin User Information by ID")
    @GetMapping("getById")
    public Result<SystemUserItemVo> getById(@RequestParam Long id) {
        SystemUserItemVo result = systemUserService.getSystemUserById(id);
        return Result.ok(result);
    }

    @Operation(summary = "Save or Update Admin User Information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemUser systemUser) { // 接收SystemUser，说明不会进行连表查询
        if (systemUser.getPassword() != null) {
            systemUser.setPassword(DigestUtils.md5Hex(systemUser.getPassword())); // 密码通过MD5转化存进数据库
        }
        systemUserService.saveOrUpdate(systemUser);
        return Result.ok();
    }

    @Operation(summary = "Check Availability of Admin Username")
    @GetMapping("isUserNameAvailable")
    public Result<Boolean> isUsernameExists(@RequestParam String username) {
        LambdaUpdateWrapper<SystemUser> systemUserLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        systemUserLambdaUpdateWrapper.eq(SystemUser::getUsername, username);
        long count = systemUserService.count(systemUserLambdaUpdateWrapper);
        return Result.ok(count == 0);
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "Delete Admin User Information by ID")
    public Result removeById(@RequestParam Long id) {
        systemUserService.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "Update Admin User Status by ID")
    @PostMapping("updateStatusByUserId")
    public Result updateStatusByUserId(@RequestParam Long id, @RequestParam BaseStatus status) {
        LambdaUpdateWrapper<SystemUser> systemUserLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        systemUserLambdaUpdateWrapper.eq(SystemUser::getId, id);
        systemUserLambdaUpdateWrapper.set(SystemUser::getStatus, status);
        systemUserService.update(systemUserLambdaUpdateWrapper);
        return Result.ok();
    }
}
