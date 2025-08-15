package com.nest.renting.web.admin.schedule;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.nest.renting.model.entity.LeaseAgreement;
import com.nest.renting.model.enums.LeaseSourceType;
import com.nest.renting.model.enums.LeaseStatus;
import com.nest.renting.web.admin.service.LeaseAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledTasks {

    @Autowired
    private LeaseAgreementService leaseAgreementService;

    @Scheduled(cron = "0 0 0 * * *")
    public void checkLeaseStatus() {
        LambdaUpdateWrapper<LeaseAgreement> leaseAgreementLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        leaseAgreementLambdaUpdateWrapper.le(LeaseAgreement::getLeaseEndDate, new Date());
        leaseAgreementLambdaUpdateWrapper.in(LeaseAgreement::getStatus, LeaseStatus.SIGNED, LeaseStatus.WITHDRAWING, LeaseStatus.RENEWING);
        leaseAgreementLambdaUpdateWrapper.set(LeaseAgreement::getStatus, LeaseStatus.EXPIRED);
        leaseAgreementService.update(leaseAgreementLambdaUpdateWrapper);
    }
}
