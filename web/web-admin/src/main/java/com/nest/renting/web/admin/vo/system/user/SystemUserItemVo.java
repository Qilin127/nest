package com.nest.renting.web.admin.vo.system.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.nest.renting.model.entity.SystemUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents the basic user information for the admin system.
 * This class extends the {@link SystemUser} entity, adding additional fields
 * specific to the admin view.
 */
@Data
@Schema(description = "Basic User Information for Admin System")
public class SystemUserItemVo extends SystemUser {

    /**
     * The name of the user's position.
     * This field corresponds to the 'post_name' column in the database table.
     */
    @Schema(description = "Position name")
    @TableField(value = "post_name")
    private String postName;

}
