package com.nest.renting.common.result;

import lombok.Data;

/**
 * Global unified response wrapper
 * This class is used to encapsulate the response data, code, and message in a unified format,
 * making it convenient for the front - end to process the response information.
 */
@Data
public class Result<T> {

    // Response code, used to indicate the result status of the request
    private Integer code;

    // Response message, used to provide a brief description of the request result
    private String message;

    // Response data, which can be any type of object, determined by the generic type T
    private T data;

    public Result() {
    }

    /**
     * Private helper method to build a Result object with the given data
     *
     * @param <T>  The generic type of the response data
     * @param data The response data to be encapsulated
     * @return A Result object containing the given data
     */
    private static <T> Result<T> build(T data) {
        Result<T> result = new Result<>();
        if (data != null)
            result.setData(data);
        return result;
    }

    /**
     * Build a Result object with the given data and result code enumeration
     *
     * @param <T>              The generic type of the response data
     * @param body             The response data to be encapsulated
     * @param resultCodeEnum   The result code enumeration, containing the response code and message
     * @return A Result object containing the given data, code, and message
     */
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * Build a successful Result object with the given data
     *
     * @param <T>  The generic type of the response data
     * @param data The response data to be encapsulated
     * @return A successful Result object containing the given data
     */
    public static <T> Result<T> ok(T data) {
        return build(data, ResultCodeEnum.SUCCESS);
    }

    /**
     * Build a successful Result object without data
     *
     * @param <T> The generic type of the response data
     * @return A successful Result object with null data
     */
    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * Build a failed Result object without custom code and message
     *
     * @param <T> The generic type of the response data
     * @return A failed Result object with default failure code and message
     */
    public static <T> Result<T> fail() {
        return build(null, ResultCodeEnum.FAIL);
    }

    /**
     * Build a failed Result object with custom code and message
     *
     * @param <T>     The generic type of the response data
     * @param code    The custom response code
     * @param message The custom response message
     * @return A failed Result object with the given code and message
     */
    public static <T> Result<T> fail(Integer code, String message) {
        Result<T> result = build(null);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
