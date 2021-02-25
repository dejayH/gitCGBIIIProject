package com.cy.pj.sys.controller;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.pojo.JsonResult;
import com.cy.pj.common.util.PageUtil;
import com.cy.pj.sys.pojo.SysUser;
import com.cy.pj.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
//@CrossOrigin
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/login/{username}/{password}")
    public JsonResult doLogin(@PathVariable String username, @PathVariable String password) {

        Subject subject = SecurityUtils.getSubject();
        System.out.println("username=="+username);
        //执行登录(将用户名和密码提交给securitymanager)
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        subject.login(token);
        return new JsonResult("login successful");
    }

//    @RequiresPermissions("sys:user:view")
    @RequiredLog(operation="用户列表")
    @GetMapping
    public JsonResult doFindUsers(SysUser entity) {
        return new JsonResult(PageUtil.startPage().doSelectPageInfo(() -> sysUserService.findUsers(entity)));
    }

    @PostMapping
    public JsonResult doSaveUser(@RequestBody SysUser entity) {
        sysUserService.saveUser(entity);
        return new JsonResult("savedSuccessfully");
    }

    @GetMapping("/{id}")
    public JsonResult doFindById(@PathVariable Integer id) {
        return new JsonResult(sysUserService.findById(id));
    }


    @PutMapping
    public JsonResult doUpdateUser(@RequestBody SysUser entity) {
        sysUserService.updateUser(entity);
        return new JsonResult("update complete");
    }

    /**
     * 更新用户状态
     * @param id 用户id
     * @param valid 用户状态
     * @return
     *  @RequiresPermissions 注解由shiro框架定义，基于此注解定义授权切入点方法，
     *  也就是说用户访问此方法时，需要授权才可访问。shiro框架底层会基于登录用户
     *  获取登录用户权限(菜单的权限标识)，然后判定用户权限中是否包含@RequiresPermissions
     *  注解中定义的权限标识.
     */
    @RequiresPermissions("sys:user:update")
    @PatchMapping("/{id}/{valid}")
    public JsonResult doValidById(@PathVariable Integer id, @PathVariable Integer valid) {
        sysUserService.validById(id, valid);
        return new JsonResult("status Change Complete");
    }
}
