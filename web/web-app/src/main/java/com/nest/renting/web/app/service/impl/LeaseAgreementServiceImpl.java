package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.LeaseAgreement;
import com.nest.renting.web.app.mapper.LeaseAgreementMapper;
import com.nest.renting.web.app.service.LeaseAgreementService;
import com.nest.renting.web.app.vo.agreement.AgreementItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement> implements LeaseAgreementService {

    @Autowired
    LeaseAgreementMapper leaseAgreementMapper;

    @Override
    public List<AgreementItemVo> listAgreementItemByPhone(String phone) {
        return leaseAgreementMapper.listAgreementItemByPhone(phone);
    }

}




