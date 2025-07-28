package com.nest.renting.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseEntity serves as the base class for all entity classes in the application.
 * It provides common fields such as primary key, creation time, last update time, and logical deletion flag.
 * This class implements the Serializable interface, allowing objects of this class to be serialized.
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * Primary key of the entity.
     * Automatically incremented when a new record is inserted into the database.
     */
    @Schema(description = "Primary Key")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * Creation time of the entity.
     * This field is automatically populated when a new record is inserted into the database.
     * It is ignored during JSON serialization to prevent it from being sent to the frontend.
     */
    @Schema(description = "Creation Time")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonIgnore
    private Date createTime;

    /**
     * Last update time of the entity.
     * This field is automatically updated when a record is updated in the database.
     * It is ignored during JSON serialization to prevent it from being sent to the frontend.
     */
    @Schema(description = "Last Update Time")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @JsonIgnore
    private Date updateTime;

    /**
     * Logical deletion flag of the entity.
     * Instead of physically deleting records from the database, this flag is used to mark records as deleted.
     * It is ignored during JSON serialization to prevent it from being sent to the frontend.
     */
    @Schema(description = "Logical Deletion Flag")
    @TableField("is_deleted")
    @TableLogic // Use default logical deletion
    @JsonIgnore // Do not return this to frontend
    private Byte isDeleted;

}