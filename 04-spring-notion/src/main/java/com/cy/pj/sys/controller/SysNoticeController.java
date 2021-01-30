package com.cy.pj.sys.controller;

import com.cy.pj.sys.dao.SysNotice;
import com.cy.pj.sys.pojo.pojoSysNotice;
import com.cy.pj.sys.service.SysnoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class SysNoticeController {

    @Autowired
    private SysnoticeService sysnoticeService;

    @RequestMapping("/doFindNotices")
    public List<pojoSysNotice> doFindNotices(pojoSysNotice notice) {
        return sysnoticeService.findNotices(notice);
    }

    @RequestMapping("/doSaveNotice")
    public String doSaveNotice(pojoSysNotice notice) {
        sysnoticeService.saveNotice(notice);
        System.out.println("save ok");
        return "save ok";
    }

    @RequestMapping("/doFingById/{id}")
    public pojoSysNotice doFindById(@PathVariable Long id) {

        return sysnoticeService.findById(id);
    }

    @RequestMapping("/doUpdateNotice")
    public String doUpdateNotice(pojoSysNotice notice){
        sysnoticeService.updateNotice(notice);
        return "update ok";
    }

    @RequestMapping("/doDeleteNotice")
    public String doDeleteNotice(Long... ids){
        sysnoticeService.deleteById(ids);
        return "delete ok";
    }


}
