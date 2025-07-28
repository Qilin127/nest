package com.nest.renting.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.LeaseAgreement;
import com.nest.renting.web.admin.vo.agreement.AgreementQueryVo;
import com.nest.renting.web.admin.vo.agreement.AgreementVo;

/**
* @description The database operation Mapper for the table [lease_agreement(Lease information table)]
* @Entity com.atguigu.lease.model.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> pageAgreement(IPage<AgreementVo> agreementVoIPage, AgreementQueryVo queryVo);
}




