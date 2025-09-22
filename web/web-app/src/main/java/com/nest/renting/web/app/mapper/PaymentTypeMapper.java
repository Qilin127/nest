package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.PaymentType;

import java.util.List;

/**
 * PaymentTypeMapper
 *
 * Data access layer for performing database operations
 * on the {@link PaymentType} entity (payment type table).
 * Provides methods to query payment types associated with specific rooms.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {

    /**
     * Retrieve a list of payment types available for a given room.
     *
     * @param id the room ID
     * @return a list of {@link PaymentType} linked to the room
     */
    List<PaymentType> selectListByRoomId(Long id);
}



