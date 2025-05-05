package com.nest.renting.web.admin.vo.system.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.nest.renting.model.entity.SystemUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "Basic User Information for Admin System")
public class SystemUserItemVo extends SystemUser {

    @Schema(description = "Position name")
    @TableField(value = "post_name")
    private String postName;

}
