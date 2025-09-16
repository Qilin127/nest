package com.nest.renting.web.app.controller.appointment;

import com.nest.renting.common.login.LoginUserHolder;
import com.nest.renting.model.entity.ViewAppointment;
import com.nest.renting.web.app.service.ViewAppointmentService;
import com.nest.renting.web.app.vo.appointment.AppointmentDetailVo;
import com.nest.renting.web.app.vo.appointment.AppointmentItemVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nest.renting.common.result.Result;
import java.util.List;


@Tag(name = "House viewing appointment information")
@RestController
@RequestMapping("/app/appointment")
public class ViewAppointmentController {

    @Autowired
    private ViewAppointmentService service;

    @Operation(summary = "Save or update viewing appointment")
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ViewAppointment viewAppointment) {
        viewAppointment.setUserId(LoginUserHolder.getLoginUser().getUserId());
        service.saveOrUpdate(viewAppointment);
        return Result.ok();
    }

    @Operation(summary = "Query personal appointment viewing list")
    @GetMapping("/listItem")
    public Result listItem() {
        List<AppointmentItemVo> list = service.listAppointmentItemByUserId(LoginUserHolder.getLoginUser().getUserId());
        return Result.ok(list);
    }

    @GetMapping("/getDetailById")
    @Operation(summary = "Query reservation details by ID")
    public Result getDetailById(Long id) {
        AppointmentDetailVo detail = service.getAppointmentDetailVoById(id);
        return Result.ok(detail);
    }

}

