package com.cy.pj.sys.controller;

import com.cy.pj.common.pojo.JsonResult;
import com.cy.pj.common.util.PageUtil;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/checkRoles")
    public JsonResult doFindCheckRoles() {
        return new JsonResult(sysRoleService.findCheckRoles());
    }


    @PutMapping
    public JsonResult doUpdataRole(@RequestBody SysRole entity) {
        sysRoleService.updateRole(entity);
        return new JsonResult("updateCompleted");
    }

    @GetMapping("/{id}")
    public JsonResult doFindById(@PathVariable Integer id) {
        return new JsonResult(sysRoleService.findById(id));
    }

    @PostMapping
    public JsonResult doSaveRole(@RequestBody SysRole entity) {
        sysRoleService.saveRole(entity);
        return new JsonResult("add TaskCompleted");
    }

    @GetMapping
    public JsonResult doFindRoles(SysRole entity) {
        return new JsonResult(
                PageUtil.startPage().doSelectPageInfo(
                        () -> sysRoleService.findRoles(entity)
                )
        );
    }
}
