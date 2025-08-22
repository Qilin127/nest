package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.LeaseTerm;
import com.nest.renting.web.app.mapper.LeaseTermMapper;
import com.nest.renting.web.app.service.LeaseTermService;
import org.springframework.stereotype.Service;

@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm>
        implements LeaseTermService {

}




