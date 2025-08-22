package com.nest.renting.web.app.controller.history;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nest.renting.common.login.LoginUserHolder;
import com.nest.renting.web.app.service.BrowsingHistoryService;
import com.nest.renting.web.app.vo.history.HistoryItemVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nest.renting.common.result.Result;

@RestController
@Tag(name = "Browsing history management")
@RequestMapping("/app/history")
public class BrowsingHistoryController {

    @Autowired
    private BrowsingHistoryService service;

    /**
     * Retrieves a paginated list of browsing history records for the current logged-in user.
     *
     * <p>This endpoint queries the browsing history based on the given pagination
     * parameters (page number and page size) and returns the results in a paginated format.</p>
     *
     * @param current the current page number, starting from 1
     * @param size    the number of records per page
     * @return        a {@link Result} containing a paginated list of {@link HistoryItemVo} records
     */
    @Operation(summary = "Get browsing history")
    @GetMapping("pageItem")
    private Result<IPage<HistoryItemVo>> page(@RequestParam long current, @RequestParam long size) {

        IPage<HistoryItemVo> page = new Page<>(current, size);
        IPage<HistoryItemVo> list = service.pageHistoryItemByUserId(page, LoginUserHolder.getLoginUser().getUserId());
        return Result.ok(list);
    }

}
