package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.AttrValue;
import com.nest.renting.web.app.vo.attr.AttrValueVo;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * AttrValueMapper
 *
 * Data access layer for performing database operations
 * on the {@link AttrValue} entity (room attribute value table).
 * Provides methods to query attribute values associated with specific rooms.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */
@Repository
public interface AttrValueMapper extends BaseMapper<AttrValue> {

    /**
     * Retrieve a list of attribute values for a given room.
     *
     * @param id the room ID
     * @return a list of {@link AttrValueVo} representing the room's attributes
     */
    List<AttrValueVo> selectListByRoomId(Long id);
}




