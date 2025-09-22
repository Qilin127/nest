package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.LeaseTerm;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * LeaseTermMapper
 *
 * Data access layer for performing database operations
 * on the {@link LeaseTerm} entity (lease term table).
 * Provides methods to query lease term records associated with a specific room.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */
@Repository
public interface LeaseTermMapper extends BaseMapper<LeaseTerm> {

    /**
     * Retrieve a lease term by its unique ID.
     *
     * @param id the lease term ID
     * @return the {@link LeaseTerm} entity
     */
    LeaseTerm selectLeaseTermById(Long id);

    /**
     * Retrieve a list of lease terms for a given room.
     *
     * @param id the room ID
     * @return a list of {@link LeaseTerm} associated with the room
     */
    List<LeaseTerm> selectListByRoomId(Long id);
}




