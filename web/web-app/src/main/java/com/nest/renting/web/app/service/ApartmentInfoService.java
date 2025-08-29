package com.nest.renting.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.web.app.vo.apartment.ApartmentItemVo;

public interface ApartmentInfoService extends IService<ApartmentInfo> {

    ApartmentItemVo getApartmentItemVoById(Long apartmentId);

}
