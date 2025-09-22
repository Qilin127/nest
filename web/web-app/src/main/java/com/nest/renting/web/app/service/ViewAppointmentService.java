package com.nest.renting.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.model.entity.ViewAppointment;
import com.nest.renting.web.app.vo.appointment.AppointmentDetailVo;
import com.nest.renting.web.app.vo.appointment.AppointmentItemVo;
import java.util.List;

public interface ViewAppointmentService extends IService<ViewAppointment> {

    List<AppointmentItemVo> listAppointmentItemByUserId(Long userId);

    AppointmentDetailVo getAppointmentDetailVoById(Long id);
}
