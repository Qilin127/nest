package com.nest.renting.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.model.entity.LeaseAgreement;
import com.nest.renting.web.app.vo.agreement.AgreementDetailVo;
import com.nest.renting.web.app.vo.agreement.AgreementItemVo;

import java.util.List;

public interface LeaseAgreementService extends IService<LeaseAgreement> {

    List<AgreementItemVo> listAgreementItemByPhone(String phone);

    AgreementDetailVo getAgreementDetailById(Long id);
}
