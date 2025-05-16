package com.nest.renting.common.exception;

import com.nest.renting.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * Custom exception
 */
@Data
public class RentingException extends RuntimeException {

    private Integer code;

    public RentingException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public RentingException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
}
