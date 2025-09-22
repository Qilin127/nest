package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.FacilityInfo;

import java.util.List;

/**
 * FacilityInfoMapper
 *
 * Data access layer for performing database operations
 * on the {@link FacilityInfo} entity (facility information table).
 * Provides methods to query facility records associated with rooms or apartments.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

    /**
     * Retrieve a list of facilities associated with a specific room.
     *
     * @param id the room ID
     * @return a list of {@link FacilityInfo} linked to the room
     */
    List<FacilityInfo> selectListByRoomId(Long id);

    /**
     * Retrieve a list of facilities associated with a specific apartment.
     *
     * @param id the apartment ID
     * @return a list of {@link FacilityInfo} linked to the apartment
     */
    List<FacilityInfo> selectListByApartmentId(Long id);
}




