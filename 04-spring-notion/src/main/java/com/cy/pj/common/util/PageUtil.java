package com.cy.pj.common.util;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {
//    public void startPAge(){
//        String pageSize=null;
//        String pageCurrent=null;
//    }
    public static void startPage(){
        HttpServletRequest request=ServletUtil.getRequest();
        //页面大小(每页最多显示多少条记录)
        String pageSize=request.getParameter("pageSize");
        //当前页码值(要查第几页的数据)
        String pageCurrent=request.getParameter("pageCurrent");
        System.out.println("pageSize="+pageSize);
        System.out.println("pageCurrent="+pageCurrent);
        //在此位置调用PageHelper中的一个方法启动分页
        //在项目中去添加一个PageHelper依赖(后缀是starter的)
    }
}
