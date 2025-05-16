package com.nest.renting.web.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.web.admin.vo.apartment.ApartmentItemVo;
import com.nest.renting.web.admin.vo.apartment.ApartmentQueryVo;

/**
* @description Operate the Mapper for the database of the table [apartment_info(Apartment information table)]
* @Entity com.atguigu.lease.model.ApartmentInfo
*/
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> apartmentItemVoPage, ApartmentQueryVo queryVo);
}




