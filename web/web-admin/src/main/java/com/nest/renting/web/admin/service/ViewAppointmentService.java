package com.nest.renting.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.ViewAppointment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.web.admin.vo.appointment.AppointmentQueryVo;
import com.nest.renting.web.admin.vo.appointment.AppointmentVo;

/**
* @description Operate the Service for the database of the table [view_appointment(house Viewing Information Table)]
*/
public interface ViewAppointmentService extends IService<ViewAppointment> {
    IPage<AppointmentVo> pageAppointmentByQuery(IPage<AppointmentVo> page, AppointmentQueryVo queryVo);

}
