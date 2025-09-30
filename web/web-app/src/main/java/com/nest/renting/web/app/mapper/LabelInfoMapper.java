package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.LabelInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {
    List<LabelInfo> selectListByApartmentId(Long apartmentId);

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




