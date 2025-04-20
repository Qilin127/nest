package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.GraphInfo;
import com.nest.renting.web.admin.mapper.GraphInfoMapper;
import com.nest.renting.web.admin.service.GraphInfoService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [graph_info(image information table)]
*/
@Service
public class GraphInfoServiceImpl extends ServiceImpl<GraphInfoMapper, GraphInfo>
    implements GraphInfoService {

}




