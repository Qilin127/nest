package com.nest.renting.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.GraphInfo;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.admin.vo.graph.GraphVo;

import java.util.List;

/**
* @description The database operation Mapper for the table [graph_info(image information table)]
* @Entity com.atguigu.lease.model.GraphInfo
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {
    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long id);
}




