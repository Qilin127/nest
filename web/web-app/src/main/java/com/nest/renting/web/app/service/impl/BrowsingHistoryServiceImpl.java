package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.BrowsingHistory;
import com.nest.renting.web.app.mapper.BrowsingHistoryMapper;
import com.nest.renting.web.app.service.BrowsingHistoryService;
import org.springframework.stereotype.Service;

@Service
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory>
        implements BrowsingHistoryService {
}