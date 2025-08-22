package com.nest.renting.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.model.entity.BrowsingHistory;
import com.nest.renting.web.app.vo.history.HistoryItemVo;

public interface BrowsingHistoryService extends IService<BrowsingHistory> {

    IPage<HistoryItemVo> pageHistoryItemByUserId(IPage<HistoryItemVo> page, Long userId);

    void saveHistory(Long userId, Long id);

}
