package com.nest.renting.web.admin.custom.converter;

import com.nest.renting.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * The general converter
 */
@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return source -> {
            for (T enumConstant : targetType.getEnumConstants()) {
                if (enumConstant.getCode().equals(Integer.valueOf(source))) {
                    return enumConstant;
                }
            }
            throw new IllegalArgumentException("code:" + source + " is not a valid item type");
        };
    }
}
