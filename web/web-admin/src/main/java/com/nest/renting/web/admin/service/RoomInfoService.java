package com.nest.renting.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.RoomInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.web.admin.vo.room.RoomDetailVo;
import com.nest.renting.web.admin.vo.room.RoomItemVo;
import com.nest.renting.web.admin.vo.room.RoomQueryVo;
import com.nest.renting.web.admin.vo.room.RoomSubmitVo;

/**
* @description The database operation Service for the table [room_info(Room Information table)]
*/
public interface RoomInfoService extends IService<RoomInfo> {
    void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo);

    IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> itemVoIPage, RoomQueryVo queryVo);

    RoomDetailVo getDetailById(Long id);

}
