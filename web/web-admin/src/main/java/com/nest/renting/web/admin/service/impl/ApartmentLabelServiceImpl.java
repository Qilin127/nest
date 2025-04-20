package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.ApartmentLabel;
import com.nest.renting.web.admin.mapper.ApartmentLabelMapper;
import com.nest.renting.web.admin.service.ApartmentLabelService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [apartment_label(apartment label Association Table)]
*/
@Service
public class ApartmentLabelServiceImpl extends ServiceImpl<ApartmentLabelMapper, ApartmentLabel>
    implements ApartmentLabelService {

}




