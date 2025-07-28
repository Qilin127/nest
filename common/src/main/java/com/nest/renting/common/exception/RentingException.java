package com.nest.renting.common.exception;

import com.nest.renting.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * Custom exception class, extending the RuntimeException class, used to handle specific business exceptions in the renting system.
 * This class includes an error code field to provide more detailed error information.
 */
@Data
public class RentingException extends RuntimeException {

    /**
     * Error code, used to identify different types of exceptions.
     */
    private Integer code;

    /**
     * Constructs a new renting exception with the specified error code and detail message.
     *
     * @param code    Error code, used to identify the type of exception.
     * @param message Detail message, which provides more information about the exception.
     */
    public RentingException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * Constructs a new renting exception based on the specified result code enumeration.
     *
     * @param resultCodeEnum Result code enumeration, containing error code and error message.
     */
    public RentingException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
}

