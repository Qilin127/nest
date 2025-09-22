package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.FeeValue;
import com.nest.renting.web.app.vo.fee.FeeValueVo;

import java.util.List;

/**
 * FeeValueMapper
 *
 * Data access layer for performing database operations
 * on the {@link FeeValue} entity (miscellaneous fee value table).
 * Provides methods to query fee values associated with specific apartments.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */
import org.springframework.stereotype.Repository;

@Repository
public interface FeeValueMapper extends BaseMapper<FeeValue> {

    /**
     * Retrieve a list of miscellaneous fees for a given apartment.
     *
     * @param id the apartment ID
     * @return a list of {@link FeeValueVo} representing the apartment's fee values
     */
    List<FeeValueVo> selectListByApartmentId(Long id);
}




