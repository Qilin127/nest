package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.*;
import com.nest.renting.web.admin.mapper.*;
import com.nest.renting.web.admin.service.LeaseAgreementService;
import com.nest.renting.web.admin.vo.agreement.AgreementQueryVo;
import com.nest.renting.web.admin.vo.agreement.AgreementVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description The implementation of the database operation Service for the table [lease_agreement(Lease information Table)]
 */
@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
        implements LeaseAgreementService {

        @Autowired
        private LeaseAgreementMapper leaseAgreementMapper;
        @Autowired
        private ApartmentInfoMapper apartmentInfoMapper;
        @Autowired
        private RoomInfoMapper roomInfoMapper;
        @Autowired
        private PaymentTypeMapper paymentTypeMapper;
        @Autowired
        private LeaseTermMapper leaseTermMapper;

        @Override
        public IPage<AgreementVo> pageAgreement(IPage<AgreementVo> agreementVoIPage, AgreementQueryVo queryVo) {
            return leaseAgreementMapper.pageAgreement(agreementVoIPage, queryVo);
        }

    @Override
    public AgreementVo getAgreementById(Long id) {

        // 1. Query lease agreement information
        LeaseAgreement leaseAgreement = leaseAgreementMapper.selectById(id);

        // 2. Query apartment information
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(leaseAgreement.getApartmentId());

        // 3. Query room information
        RoomInfo roomInfo = roomInfoMapper.selectById(leaseAgreement.getRoomId());

        // 4. Query payment type
        PaymentType paymentType = paymentTypeMapper.selectById(leaseAgreement.getPaymentTypeId());

        // 5. Query lease term
        LeaseTerm leaseTerm = leaseTermMapper.selectById(leaseAgreement.getLeaseTermId());

        AgreementVo agreementVo = new AgreementVo();

        BeanUtils.copyProperties(leaseAgreement, agreementVo);

        agreementVo.setApartmentInfo(apartmentInfo);
        agreementVo.setRoomInfo(roomInfo);
        agreementVo.setPaymentType(paymentType);
        agreementVo.setLeaseTerm(leaseTerm);

        return agreementVo;
    }

}




