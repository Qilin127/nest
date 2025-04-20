package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.BrowsingHistory;
import com.nest.renting.web.admin.mapper.BrowsingHistoryMapper;
import com.nest.renting.web.admin.service.BrowsingHistoryService;
import org.springframework.stereotype.Service;

/**
* @description The implementation of the database operation Service for the table [browsing_history(browsing history)]
*/
@Service
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory>
    implements BrowsingHistoryService {

}




