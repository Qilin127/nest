package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.LeaseAgreement;
import com.nest.renting.web.app.vo.agreement.AgreementItemVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    List<AgreementItemVo> listAgreementItemByPhone(String phone);


}




