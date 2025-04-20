package com.nest.renting.web.admin.controller.user;

import com.nest.renting.common.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.UserInfo;
import com.nest.renting.model.enums.BaseStatus;
import com.nest.renting.web.admin.service.UserInfoService;
import com.nest.renting.web.admin.vo.user.UserInfoQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Information Management")
@RestController
@RequestMapping("/admin/user")
public class UserInfoController {

    @Operation(summary = "Paginated Query of User Information")
    @GetMapping("page")
    public Result<IPage<UserInfo>> pageUserInfo(@RequestParam long current, @RequestParam long size, UserInfoQueryVo queryVo) {
        return Result.ok();
    }

    @Operation(summary = "Update Account Status by User ID")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam BaseStatus status) {
        return Result.ok();
    }
}
