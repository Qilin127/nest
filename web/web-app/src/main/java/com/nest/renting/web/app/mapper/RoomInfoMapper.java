package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.RoomInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    RoomInfo selectRoomById(Long roomId);
}