package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.RoomLabel;
import com.nest.renting.web.admin.mapper.RoomLabelMapper;
import com.nest.renting.web.admin.service.RoomLabelService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [room_label(Room & Label Association Table)]
*/
@Service
public class RoomLabelServiceImpl extends ServiceImpl<RoomLabelMapper, RoomLabel>
    implements RoomLabelService {

}




