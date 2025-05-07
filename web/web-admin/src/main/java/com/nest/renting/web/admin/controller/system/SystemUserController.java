package com.nest.renting.web.admin.controller.system;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Admin User Information Management")
@RestController
@RequestMapping("/admin/system/user")
public class SystemUserController {

    @Autowired
    private SystemUserService service;

    @Operation(summary = "Paginated Query of Admin User List Based on Conditions")
    @GetMapping("page")
    public Result<IPage<SystemUserItemVo>> page(@RequestParam long current, @RequestParam long size, SystemUserQueryVo queryVo) {
        IPage<SystemUser> page = new Page<>(current, size);
        IPage<SystemUserItemVo> systemUserPage = service.pageSystemUserByQuery(page, queryVo);
        return Result.ok(systemUserPage);
    }

    @Operation(summary = "Retrieve Admin User Information by ID")
    @GetMapping("getById")
    public Result<SystemUserItemVo> getById(@RequestParam Long id) {
        SystemUserItemVo systemUser = service.getSystemUserById(id);
        return Result.ok(systemUser);
    }

    @Operation(summary = "Save or Update Admin User Information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemUser systemUser) { // 接收SystemUser，说明不会进行连表查询
        return Result.ok();
    }

    @Operation(summary = "Check Availability of Admin Username")
    @GetMapping("isUserNameAvailable")
    public Result<Boolean> isUsernameExists(@RequestParam String username) {
        return Result.ok();
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "Delete Admin User Information by ID")
    public Result removeById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "Update Admin User Status by ID")
    @PostMapping("updateStatusByUserId")
    public Result updateStatusByUserId(@RequestParam Long id, @RequestParam BaseStatus status) {
        return Result.ok();
    }
}
