package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.FeeValue;
import com.nest.renting.web.admin.mapper.FeeValueMapper;
import com.nest.renting.web.admin.service.FeeValueService;
import org.springframework.stereotype.Service;

/**
* @descriptionThe implementation of the database operation Service for the table [fee_value(Miscellaneous Cost Value Table)]
*/
@Service
public class FeeValueServiceImpl extends ServiceImpl<FeeValueMapper, FeeValue>
    implements FeeValueService {

}




