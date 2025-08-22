package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nest.renting.model.entity.BrowsingHistory;
import com.nest.renting.web.app.vo.history.HistoryItemVo;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowsingHistoryMapper extends BaseMapper<BrowsingHistory> {

    IPage<HistoryItemVo> pageHistoryItemByUserId(IPage<HistoryItemVo> page, Long userId);

}




