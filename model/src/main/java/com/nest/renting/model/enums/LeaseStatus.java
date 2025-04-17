package com.nest.renting.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LeaseStatus implements BaseEnum {

    SIGNING(1, "Signing Pending Confirmation"), // 签约待确认
    SIGNED(2, "Signed"),                        // 已签约
    CANCELED(3, "Canceled"),                    // 已取消
    EXPIRED(4, "Expired"),                      // 已到期
    WITHDRAWING(5, "Withdrawal Pending Confirmation"), // 退租待确认
    WITHDRAWN(6, "Withdrawn"),                         // 已退租
    RENEWING(7, "Renewal Pending Confirmation");       // 续约待确认


    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    LeaseStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
