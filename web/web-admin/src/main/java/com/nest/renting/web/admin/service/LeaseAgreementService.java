package com.nest.renting.web.admin.service;

import com.nest.renting.model.entity.LeaseAgreement;
import com.nest.renting.web.admin.vo.agreement.AgreementQueryVo;
import com.nest.renting.web.admin.vo.agreement.AgreementVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @description The database operation Service for the table [lease_agreement(Lease information table)]
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {

    IPage<AgreementVo> pageAgreement(IPage<AgreementVo> agreementVoIPage, AgreementQueryVo queryVo);

    AgreementVo getAgreementById(Long id);
}

