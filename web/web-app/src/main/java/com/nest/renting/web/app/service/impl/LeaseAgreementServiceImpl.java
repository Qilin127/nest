package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.LeaseAgreement;
import com.nest.renting.web.app.mapper.LeaseAgreementMapper;
import com.nest.renting.web.app.service.LeaseAgreementService;
import org.springframework.stereotype.Service;

@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
        implements LeaseAgreementService {

}




