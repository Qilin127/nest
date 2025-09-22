package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.LabelInfo;

import java.util.List;

/**
 * LabelInfoMapper
 *
 * Data access layer for performing database operations
 * on the {@link LabelInfo} entity (label information table).
 * Provides methods to query labels associated with rooms or apartments.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {

    /**
     * Retrieve a list of labels associated with a specific room.
     *
     * @param id the room ID
     * @return a list of {@link LabelInfo} linked to the room
     */
    List<LabelInfo> selectListByRoomId(Long id);

    /**
     * Retrieve a list of labels associated with a specific apartment.
     *
     * @param apartmentId the apartment ID
     * @return a list of {@link LabelInfo} linked to the apartment
     */
    List<LabelInfo> selectListByApartmentId(Long apartmentId);
}




