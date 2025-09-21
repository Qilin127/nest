package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.*;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.app.mapper.*;
import com.nest.renting.web.app.service.LeaseAgreementService;
import com.nest.renting.web.app.vo.agreement.AgreementDetailVo;
import com.nest.renting.web.app.vo.agreement.AgreementItemVo;
import com.nest.renting.web.app.vo.graph.GraphVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement> implements LeaseAgreementService {

    @Autowired
    LeaseAgreementMapper leaseAgreementMapper;
    @Autowired
    ApartmentInfoMapper apartmentInfoMapper;
    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Autowired
    GraphInfoMapper graphInfoMapper;
    @Autowired
    LeaseTermMapper leaseTermMapper;
    @Autowired
    PaymentTypeMapper paymentTypeMapper;

    @Override
    public List<AgreementItemVo> listAgreementItemByPhone(String phone) {
        return leaseAgreementMapper.listAgreementItemByPhone(phone);
    }

    @Override
    public AgreementDetailVo getAgreementDetailById(Long id) {

        LeaseAgreement leaseAgreement = leaseAgreementMapper.selectById(id);
        if (leaseAgreement == null) {
            return null;
        }

        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectApartmentById(leaseAgreement.getApartmentId());

        RoomInfo roomInfo = roomInfoMapper.selectRoomById(leaseAgreement.getRoomId());

        List<GraphVo> apartmentGraphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.APARTMENT, leaseAgreement.getApartmentId());

        List<GraphVo> roomGraphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, leaseAgreement.getRoomId());

        LeaseTerm leaseTerm = leaseTermMapper.selectLeaseTermById(leaseAgreement.getLeaseTermId());

        PaymentType paymentType = paymentTypeMapper.selectPaymentTypeById(leaseAgreement.getPaymentTypeId());

        AgreementDetailVo agreementDetailVo = new AgreementDetailVo();
        BeanUtils.copyProperties(leaseAgreement, agreementDetailVo);
        agreementDetailVo.setApartmentName(apartmentInfo.getName());
        agreementDetailVo.setRoomNumber(roomInfo.getRoomNumber());
        agreementDetailVo.setApartmentGraphVoList(apartmentGraphVoList);
        agreementDetailVo.setRoomGraphVoList(roomGraphVoList);
        agreementDetailVo.setPaymentTypeName(paymentType.getName());
        agreementDetailVo.setLeaseTermMonthCount(leaseTerm.getMonthCount());
        agreementDetailVo.setLeaseTermUnit(leaseTerm.getUnit());

        return agreementDetailVo;
    }

}




