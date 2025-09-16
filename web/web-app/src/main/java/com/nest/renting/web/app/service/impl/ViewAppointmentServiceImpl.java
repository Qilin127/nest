package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.ViewAppointment;
import com.nest.renting.web.app.mapper.ViewAppointmentMapper;
import com.nest.renting.web.app.service.ApartmentInfoService;
import com.nest.renting.web.app.service.ViewAppointmentService;
import com.nest.renting.web.app.vo.apartment.ApartmentItemVo;
import com.nest.renting.web.app.vo.appointment.AppointmentDetailVo;
import com.nest.renting.web.app.vo.appointment.AppointmentItemVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment> implements ViewAppointmentService {

    @Autowired
    ViewAppointmentMapper viewAppointmentMapper;

    @Autowired
    ApartmentInfoService apartmentInfoService;

    @Override
    public List<AppointmentItemVo> listAppointmentItemByUserId(Long userId) {
        return viewAppointmentMapper.listAppointmentItemByUserId(userId);
    }


    @Override
    public AppointmentDetailVo getAppointmentDetailVoById(Long id) {

        ViewAppointment viewAppointment = viewAppointmentMapper.selectById(id);
        if (viewAppointment == null) {
            return null;
        }

        ApartmentItemVo apartmentItemVo = apartmentInfoService.getApartmentItemVoById(viewAppointment.getApartmentId());

        AppointmentDetailVo agreementDetailVo = new AppointmentDetailVo();
        BeanUtils.copyProperties(viewAppointment, agreementDetailVo);

        agreementDetailVo.setApartmentItemVo(apartmentItemVo);

        return agreementDetailVo;
    }
}




