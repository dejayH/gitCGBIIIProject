package com.cy.pj.common.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {
//    public void startPAge(){
//        String pageSize=null;
//        String pageCurrent=null;
//    }
    public static <T>Page<T> startPage(){
        HttpServletRequest request=ServletUtil.getRequest();
        //页面大小(每页最多显示多少条记录)
        String pageSizeStr=request.getParameter("pageSize");
        //当前页码值(要查第几页的数据)
        String pageCurrentStr=request.getParameter("pageCurrent");
        System.out.println("pageSize="+pageSizeStr);
        System.out.println("pageCurrent="+pageCurrentStr);
        //在此位置调用PageHelper中的一个方法启动分页
        //在项目中去添加一个PageHelper依赖(后缀是starter的)
        Integer pageCurrent=
                StringUtil.isEmpty(pageCurrentStr)?1:Integer.parseInt(pageCurrentStr);
        Integer pageSize=
                StringUtil.isEmpty(pageSizeStr)?10:Integer.parseInt(pageSizeStr);
        //启动PageHelper中的分页拦截器(PageInterceptor)

        return PageHelper.startPage(pageCurrent,pageSize);
    }
}
