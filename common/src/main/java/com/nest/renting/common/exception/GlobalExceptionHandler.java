package com.nest.renting.common.exception;

import com.nest.renting.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    /**
     * Handle custom exceptions
     * @param e
     * @return
     */
    @ExceptionHandler(value = RentingException.class)
    @ResponseBody
    public Result handleRentingException(RentingException e) {
        e.printStackTrace();
        return Result.fail(e.getCode(), e.getMessage());
    }
}
