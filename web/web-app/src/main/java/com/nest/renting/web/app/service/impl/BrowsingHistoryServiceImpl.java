package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.BrowsingHistory;
import com.nest.renting.web.app.mapper.BrowsingHistoryMapper;
import com.nest.renting.web.app.service.BrowsingHistoryService;
import com.nest.renting.web.app.vo.history.HistoryItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory> implements BrowsingHistoryService {

    @Autowired
    BrowsingHistoryMapper browsingHistoryMapper;

    @Override
    public IPage<HistoryItemVo> pageHistoryItemByUserId(IPage<HistoryItemVo> page, Long userId) {
        return browsingHistoryMapper.pageHistoryItemByUserId(page, userId);
    }


    @Override
    public void saveHistory(Long userId, Long roomId) {

        BrowsingHistory browsingHistory = new BrowsingHistory();
        browsingHistory.setUserId(userId);
        browsingHistory.setRoomId(roomId);
        browsingHistory.setBrowseTime(new Date());

        LambdaQueryWrapper<BrowsingHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BrowsingHistory::getUserId, userId);
        queryWrapper.eq(BrowsingHistory::getRoomId, roomId);
        Long count = browsingHistoryMapper.selectCount(queryWrapper);

        if (count > 0) {
            LambdaUpdateWrapper<BrowsingHistory> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(BrowsingHistory::getUserId, userId);
            updateWrapper.eq(BrowsingHistory::getRoomId, roomId);
            browsingHistoryMapper.update(browsingHistory, updateWrapper);
        } else {
            this.save(browsingHistory);
        }

    }
}