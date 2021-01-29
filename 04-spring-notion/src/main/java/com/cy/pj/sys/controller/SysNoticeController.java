package com.cy.pj.sys.controller;

import com.cy.pj.sys.pojo.pojoSysNotice;
import com.cy.pj.sys.service.SysnoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class SysNoticeController {

    @Autowired
    private SysnoticeService sysnoticeService;

    @RequestMapping("/doFindNotices")
    public List<pojoSysNotice> doFindNotices(pojoSysNotice notice){
        return sysnoticeService.findNotices(notice);
    }


}
