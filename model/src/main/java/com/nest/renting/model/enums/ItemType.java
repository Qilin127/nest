package com.nest.renting.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the type of rental items. This enum defines different types of rental items
 * and provides mapping capabilities for database operations and JSON serialization.
 * It implements the {@link BaseEnum} interface, ensuring that each item type has a code and a name.
 */
public enum ItemType implements BaseEnum {

    /**
     * Represents an apartment rental item.
     * The code for this item type is 1, and the display name is "Apartment".
     */
    APARTMENT(1, "Apartment"),

    /**
     * Represents a room rental item.
     * The code for this item type is 2, and the display name is "Room".
     */
    ROOM(2, "Room");

    /**
     * The code value of the enum constant, used for database mapping and JSON serialization.
     * Annotated with {@link com.baomidou.mybatisplus.annotation.EnumValue} to enable MyBatis-Plus
     * to map the enum to its corresponding code value in the database.
     * Annotated with {@link com.fasterxml.jackson.annotation.JsonValue} to enable Jackson
     * to serialize/deserialize the enum using its code value.
     */
    @EnumValue
    @JsonValue 
    private Integer code;

    /**
     * The display name of the enum constant.
     */
    private String name;

    /**
     * Retrieves the code value of this enum constant.
     *
     * @return the code value of this enum constant.
     */
    @Override
    public Integer getCode() {
        return this.code;
    }

    /**
     * Retrieves the display name of this enum constant.
     *
     * @return the display name of this enum constant.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Constructs a new ItemType enum constant with the specified code and name.
     *
     * @param code the code value of the enum constant, used for database mapping and JSON serialization.
     * @param name the display name of the enum constant.
     */
    ItemType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

}
