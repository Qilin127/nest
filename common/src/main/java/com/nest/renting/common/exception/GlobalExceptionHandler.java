package com.nest.renting.common.exception;

import com.nest.renting.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Global exception handler class, used to capture and handle exceptions globally across the application.
 * This class uses Spring's @ControllerAdvice annotation to intercept exceptions thrown by controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles all general exceptions of type Exception.
     * This method is triggered when an unhandled exception of type Exception is thrown in the application.
     *
     * @param e The caught exception object.
     * @return A Result object indicating the failure of the operation.
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    /**
     * Handle custom exceptions of type RentingException.
     * This method is triggered when a RentingException is thrown in the application.
     *
     * @param e The caught RentingException object.
     * @return A Result object indicating the failure of the operation, including the error code and message from the exception.
     */
    @ExceptionHandler(value = RentingException.class)
    @ResponseBody
    public Result handleRentingException(RentingException e) {
        e.printStackTrace();
        return Result.fail(e.getCode(), e.getMessage());
    }
}
