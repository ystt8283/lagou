package com.lagou.demo.controller;

import com.lagou.demo.service.IDemoService;
import com.lagou.mvcframework.annotation.LagouAutowired;
import com.lagou.mvcframework.annotation.LagouController;
import com.lagou.mvcframework.annotation.LagouRequestMapping;
import com.lagou.mvcframework.annotation.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@LagouController
@LagouRequestMapping("/demo")
public class DemoController {

    @LagouAutowired
    private IDemoService iDemoService;

    @Security({"zhangsan", "lisi"})
    @LagouRequestMapping("/query")
    public String query(HttpServletRequest request, HttpServletResponse response, String name) {
        System.out.println("------拦截到了-------");
        return iDemoService.get(name);
    }

    @LagouRequestMapping("/testSecurity")
    public String testSecurity(HttpServletRequest request, HttpServletResponse response, String name) {
        return "testSecurity";
    }
}
