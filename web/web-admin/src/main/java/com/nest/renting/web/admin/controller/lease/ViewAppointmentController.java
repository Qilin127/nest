package com.nest.renting.web.admin.controller.lease;

import com.nest.renting.common.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.enums.AppointmentStatus;
import com.nest.renting.web.admin.vo.appointment.AppointmentQueryVo;
import com.nest.renting.web.admin.vo.appointment.AppointmentVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Viewing appointment management")
@RequestMapping("/admin/appointment")
@RestController
public class ViewAppointmentController {
    @Operation(summary = "Retrieve a paginated list of viewing appointments")
    @GetMapping("page")
    public Result<IPage<AppointmentVo>> page(@RequestParam long current, @RequestParam long size, AppointmentQueryVo queryVo) {
        return Result.ok();
    }

    @Operation(summary = "Update viewing appointment status by ID")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam AppointmentStatus status) {
        return Result.ok();
    }

}
