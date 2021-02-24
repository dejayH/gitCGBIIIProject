package com.cy.pj.sys.controller;

import com.cy.pj.common.pojo.JsonResult;
import com.cy.pj.common.util.PageUtil;
import com.cy.pj.sys.pojo.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/log")
@RestController
@CrossOrigin
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @DeleteMapping
    public JsonResult doDeleteById(@PathVariable Long... ids) {
        return new JsonResult(sysLogService.deleteById(ids));
    }

    @GetMapping("/{id}")
    public JsonResult doFindById(@PathVariable Long id) {
        return new JsonResult(sysLogService.selectById(id));
    }

    @GetMapping
    public JsonResult doFindLogs(SysLog sysLog) {
        return new JsonResult(PageUtil.startPage().doSelectPageInfo(()->sysLogService.selectLogs(sysLog)));

    }
}
