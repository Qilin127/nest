package com.nest.renting.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.LeaseAgreement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.web.admin.vo.agreement.AgreementQueryVo;
import com.nest.renting.web.admin.vo.agreement.AgreementVo;

/**
* @description The database operation Service for the table [lease_agreement(Lease information table)]
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {
    IPage<AgreementVo> pageAgreementByQuery(IPage<AgreementVo> page, AgreementQueryVo queryVo);

    AgreementVo getAgreementById(Long id);


}
