package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.ViewAppointment;
import com.nest.renting.web.app.vo.appointment.AppointmentItemVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    List<AppointmentItemVo> listAppointmentItemByUserId(Long userId);
}




