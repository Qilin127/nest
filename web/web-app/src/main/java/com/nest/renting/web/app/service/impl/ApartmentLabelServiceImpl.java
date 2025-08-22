package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.ApartmentLabel;
import com.nest.renting.web.app.mapper.ApartmentLabelMapper;
import com.nest.renting.web.app.service.ApartmentLabelService;
import org.springframework.stereotype.Service;

@Service
public class ApartmentLabelServiceImpl extends ServiceImpl<ApartmentLabelMapper, ApartmentLabel>
    implements ApartmentLabelService {
}
