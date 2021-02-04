package com.cy.pj.sys.controller;

import com.cy.pj.common.util.PageUtil;
import com.cy.pj.sys.dao.SysNotice;
import com.cy.pj.sys.pojo.pojoSysNotice;
import com.cy.pj.sys.service.SysnoticeService;
import com.cy.pj.sys.web.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class SysNoticeController {

    @Autowired
    private SysnoticeService sysnoticeService;

    @GetMapping
    public JsonResult doFindNotices(pojoSysNotice notice) {
        PageUtil.startPage();
        return new JsonResult(sysnoticeService.findNotices(notice));
    }

    @PostMapping
    public JsonResult doSaveNotice(@RequestBody pojoSysNotice notice) {
        sysnoticeService.saveNotice(notice);
        System.out.println("save ok");
        return new JsonResult("save ok");
    }

    @RequestMapping("/{id}")
    public JsonResult doFindById(@PathVariable Long id) {

        return new JsonResult(sysnoticeService.findById(id));
    }

    @PutMapping
    public JsonResult doUpdateNotice(pojoSysNotice notice){
        sysnoticeService.updateNotice(notice);
        return new JsonResult("update ok");
    }

    @DeleteMapping("/{ids}")
    public JsonResult doDeleteNotice(Long... ids){
        sysnoticeService.deleteById(ids);
        return new JsonResult("delete ok");
    }


}
