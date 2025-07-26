package com.nest.renting.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Represents the miscellaneous fee name table in the database.
 * This class extends the BaseEntity and contains information about fee item keys.
 */
@Schema(description = "Miscellaneous Fee Name Table")
@TableName(value = "fee_key")
@Data
public class FeeKey extends BaseEntity {

    /**
     * Serial version UID for the class, used for serialization compatibility.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The key of the fee item.
     */
    @Schema(description = "Fee Item Key")
    @TableField(value = "name")
    private String name;


}