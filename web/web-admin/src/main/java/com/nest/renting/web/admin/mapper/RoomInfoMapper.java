package com.nest.renting.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.RoomInfo;
import com.nest.renting.web.admin.vo.room.RoomItemVo;
import com.nest.renting.web.admin.vo.room.RoomQueryVo;

/**
* @description The database operation Mapper for the table [room_info(Room information table)]
*/
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {
    IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> itemVoIPage, RoomQueryVo queryVo);

}




