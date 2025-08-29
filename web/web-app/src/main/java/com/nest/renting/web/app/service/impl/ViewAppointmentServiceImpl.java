package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.ViewAppointment;
import com.nest.renting.web.app.mapper.ViewAppointmentMapper;
import com.nest.renting.web.app.service.ViewAppointmentService;
import com.nest.renting.web.app.vo.appointment.AppointmentItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment> implements ViewAppointmentService {

    @Autowired
    ViewAppointmentMapper viewAppointmentMapper;

    public List<AppointmentItemVo> listAppointmentItemByUserId(Long userId) {
        return viewAppointmentMapper.listAppointmentItemByUserId(userId);
    }
}




