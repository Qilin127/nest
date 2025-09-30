package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.FacilityInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {
    List<FacilityInfo> selectListByApartmentId(Long id);

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




