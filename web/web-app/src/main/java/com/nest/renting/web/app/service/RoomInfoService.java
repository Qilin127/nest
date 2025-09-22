package com.nest.renting.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.model.entity.RoomInfo;
import com.nest.renting.web.app.vo.room.RoomDetailVo;
import com.nest.renting.web.app.vo.room.RoomItemVo;
import com.nest.renting.web.app.vo.room.RoomQueryVo;

/**
 * RoomInfoService
 *
 * Service interface for performing database operations
 * on the {@link RoomInfo} entity (room information table).
 * Provides methods to query paginated room lists and retrieve room details.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */
public interface RoomInfoService extends IService<RoomInfo> {

    /**
     * Retrieve a paginated list of rooms based on query conditions.
     *
     * @param roomItemVoIPage pagination parameters (current page and page size)
     * @param queryVo query conditions for filtering room results
     * @return a paginated list of {@link RoomItemVo}
     */
    IPage<RoomItemVo> pageItem(IPage<RoomItemVo> roomItemVoIPage, RoomQueryVo queryVo);

    /**
     * Retrieve detailed room information by room ID.
     *
     * @param id the room ID
     * @return detailed information of the room as {@link RoomDetailVo}
     */
    RoomDetailVo getDetailById(Long id);

    /**
     * Retrieve a paginated list of rooms under a specific apartment.
     *
     * @param roomItemVoIPage pagination parameters (current page and page size)
     * @param id the apartment ID
     * @return a paginated list of {@link RoomItemVo} belonging to the apartment
     */
    IPage<RoomItemVo> pageItemByApartmentId(IPage<RoomItemVo> roomItemVoIPage, Long id);
}
