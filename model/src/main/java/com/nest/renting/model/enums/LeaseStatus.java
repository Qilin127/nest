package com.nest.renting.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LeaseStatus implements BaseEnum {

    SIGNING(1, "Signing Pending Confirmation"), 
    SIGNED(2, "Signed"),                       
    CANCELED(3, "Canceled"),                    
    EXPIRED(4, "Expired"),                     
    WITHDRAWING(5, "Withdrawal Pending Confirmation"), 
    WITHDRAWN(6, "Withdrawn"),                        
    RENEWING(7, "Renewal Pending Confirmation");   


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
