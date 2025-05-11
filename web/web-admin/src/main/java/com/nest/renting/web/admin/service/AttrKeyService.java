package com.nest.renting.web.admin.service;

import com.nest.renting.model.entity.AttrKey;
import com.nest.renting.web.admin.vo.attr.AttrKeyVo;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @description The database operation Service for the table [attr_key(basic attribute table of the room)]
*/
public interface AttrKeyService extends IService<AttrKey> {
    List<AttrKeyVo> listAttrInfo();//List<AttrKeyVo> is equivalent to: List<name, List<AttrValue>>
    

}
