package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.GraphInfo;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.app.vo.graph.GraphVo;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * GraphInfoMapper
 *
 * Data access layer for performing database operations
 * on the {@link GraphInfo} entity (image information table).
 * Provides methods to query image lists based on item type and item ID.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */

@Repository
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    /**
     * Retrieve a list of image information by item type and item ID.
     *
     * @param itemType the type of item (e.g., apartment, room, etc.)
     * @param id the unique identifier of the item
     * @return a list of {@link GraphVo} representing image details
     */
    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long id);
}





