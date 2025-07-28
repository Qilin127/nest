package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * Represents the association table between apartments and labels.
 * This entity class maps to the `apartment_label` table in the database.
 * It contains the relationship information between an apartment and a label.
 */
@Schema(description = "Apartment-Tag Association Table")
@TableName(value = "apartment_label")
@Data
//@Builder
public class ApartmentLabel extends BaseEntity {

    /**
     * A unique identifier for serialization.
     * This field is used to ensure compatibility between different versions of the class during serialization and deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The ID of the apartment.
     * This field references the ID of an apartment in the `apartment_info` table.
     */
    @Schema(description = "Apartment id")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    /**
     * The ID of the label.
     * This field references the ID of a label in the corresponding label table.
     */
    @Schema(description = "Label id")
    @TableField(value = "label_id")
    private Long labelId;

}