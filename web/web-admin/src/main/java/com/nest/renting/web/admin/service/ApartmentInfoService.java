package com.nest.renting.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nest.renting.model.entity.ApartmentInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.web.admin.vo.apartment.ApartmentItemVo;
import com.nest.renting.web.admin.vo.apartment.ApartmentQueryVo;
import com.nest.renting.web.admin.vo.apartment.ApartmentSubmitVo;

/**
* @description The database operation Service for the table [apartment_info(Apartment information table)]
*/
public interface ApartmentInfoService extends IService<ApartmentInfo> {

    void saveOrUpdateApartment(ApartmentSubmitVo apartmentSubmitVo);

    IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> apartmentItemVoPage, ApartmentQueryVo queryVo);
}
