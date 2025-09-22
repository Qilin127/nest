package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.RoomInfo;
import com.nest.renting.web.app.vo.room.RoomItemVo;
import com.nest.renting.web.app.vo.room.RoomQueryVo;

import java.math.BigDecimal;

/**
 * RoomInfoMapper
 *
 * Data access layer for performing database operations
 * on the {@link RoomInfo} entity (room information table).
 * Provides custom query methods for paginated room listings
 * and retrieving minimum rent values by apartment ID.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    /**
     * Retrieve a paginated list of rooms based on query conditions.
     *
     * @param roomItemVoIPage pagination parameters (current page and page size)
     * @param queryVo query conditions for filtering room results
     * @return a paginated list of {@link RoomItemVo}
     */
    IPage<RoomItemVo> pageItem(IPage<RoomItemVo> roomItemVoIPage, RoomQueryVo queryVo);

    /**
     * Retrieve the minimum rent price for all rooms under a given apartment.
     *
     * @param apartmentId the apartment ID
     * @return the minimum rent price as {@link BigDecimal}
     */
    BigDecimal selectMinRentByApartmentId(Long apartmentId);

    /**
     * Retrieve a paginated list of rooms belonging to a specific apartment.
     *
     * @param roomItemVoIPage pagination parameters (current page and page size)
     * @param id the apartment ID
     * @return a paginated list of {@link RoomItemVo} belonging to the apartment
     */
    IPage<RoomItemVo> pageItemByApartmentId(IPage<RoomItemVo> roomItemVoIPage, Long id);
}