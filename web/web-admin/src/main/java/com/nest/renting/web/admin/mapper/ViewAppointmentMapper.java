package com.nest.renting.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.ViewAppointment;
import com.nest.renting.web.admin.vo.appointment.AppointmentQueryVo;
import com.nest.renting.web.admin.vo.appointment.AppointmentVo;

/**
* @description Operate the Mapper for the database of the table [view_appointment(House Viewing Information Table)]
* @Entity com.atguigu.lease.model.ViewAppointment
*/
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    IPage<AppointmentVo> pageAppointment(IPage<AppointmentVo> appointmentVoIPage, AppointmentQueryVo queryVo);
}



