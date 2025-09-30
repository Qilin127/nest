package com.nest.renting.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.web.app.vo.apartment.ApartmentDetailVo;
import com.nest.renting.web.app.vo.apartment.ApartmentItemVo;

/**
 * ApartmentInfoService
 *
 * Service interface for performing database operations
 * on the {@link ApartmentInfo} entity (apartment information table).
 * Provides methods for retrieving apartment details and apartment item view objects.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */
public interface ApartmentInfoService extends IService<ApartmentInfo> {

    /**
     * Retrieve a simplified apartment item view object by apartment ID.
     * (Primary implementation)
     *
     * @param apartmentId the apartment ID
     * @return an {@link ApartmentItemVo} representing the apartment item
     */
    ApartmentItemVo selectApartmentItemVoById(Long apartmentId);

    /**
     * Retrieve a simplified apartment item view object by apartment ID.
     * (Alias for selectApartmentItemVoById)
     *
     * @param apartmentId the apartment ID
     * @return an {@link ApartmentItemVo} representing the apartment item
     */
    ApartmentItemVo getApartmentItemVoById(Long apartmentId);

    ApartmentDetailVo getDetailById(Long id);


}
