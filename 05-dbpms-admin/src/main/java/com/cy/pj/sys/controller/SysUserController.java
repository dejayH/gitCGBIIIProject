package com.cy.pj.sys.controller;

import com.cy.pj.common.pojo.JsonResult;
import com.cy.pj.common.util.PageUtil;
import com.cy.pj.sys.pojo.SysUser;
import com.cy.pj.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping
    public JsonResult doFindUsers(SysUser entity){
        return new JsonResult(PageUtil.startPage().doSelectPageInfo(()->sysUserService.findUsers(entity)));
    }

    @PostMapping
    public JsonResult doSaveUser(@RequestBody SysUser entity){
        sysUserService.saveUser(entity);
        return new JsonResult("savedSuccessfully");
    }

    @GetMapping("/{id}")
    public JsonResult doFindById(@PathVariable Integer id){
        return new JsonResult(sysUserService.findById(id));
    }

    @PutMapping
    public JsonResult doUpdateUser(@RequestBody SysUser entity){
        sysUserService.updateUser(entity);
        return new JsonResult("update complete");
    }

    @PatchMapping("/{id}/{valid}")
    public JsonResult doValidById(@PathVariable Integer id,@PathVariable Integer valid){
        sysUserService.validById(id,valid);
        return new JsonResult("status Change Complete");
    }
}
