package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.RoomLeaseTerm;
import com.nest.renting.web.admin.mapper.RoomLeaseTermMapper;
import com.nest.renting.web.admin.service.RoomLeaseTermService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [room_lease_term(Room Rental Period Management Table)]
*/
@Service
public class RoomLeaseTermServiceImpl extends ServiceImpl<RoomLeaseTermMapper, RoomLeaseTerm>
    implements RoomLeaseTermService {

}




