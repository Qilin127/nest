package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Apartment-Tag Association Table")
@TableName(value = "apartment_label")
@Data
//@Builder
public class ApartmentLabel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Apartment id")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "Label id")
    @TableField(value = "label_id")
    private Long labelId;

}