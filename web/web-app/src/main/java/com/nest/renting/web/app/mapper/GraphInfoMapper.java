package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.GraphInfo;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.app.vo.graph.GraphVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long apartmentId);
}




