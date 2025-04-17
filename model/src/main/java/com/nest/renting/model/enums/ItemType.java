package com.nest.renting.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;


public enum ItemType implements BaseEnum {

    APARTMENT(1, "Apartment"),

    ROOM(2, "Room");

     /**
     * @EnumValue: Enables MyBatis-Plus to map between the ItemType enum and its corresponding 'code' value in the database.
     * Without this annotation, MyBatis-Plus would use the enum name (e.g., "APARTMENT") in SQL statements instead of its code.
     */
    @EnumValue 

     /**
     * @JsonValue: Enables Jackson to serialize/deserialize the enum using its 'code' value.
     * This affects how the enum is represented in controller responses to the frontend.
     */
    @JsonValue 
    private Integer code;
    private String name;

    @Override
    public Integer getCode() {
        return this.code;
    }


    @Override
    public String getName() {
        return name;
    }

    ItemType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

}
