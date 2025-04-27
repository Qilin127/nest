package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.LeaseTerm;
import com.nest.renting.web.admin.mapper.LeaseTermMapper;
import com.nest.renting.web.admin.service.LeaseTermService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [lease_term(rental period)]
*/
@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm>
    implements LeaseTermService {

}




