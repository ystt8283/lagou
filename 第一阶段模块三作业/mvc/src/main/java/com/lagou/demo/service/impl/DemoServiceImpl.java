package com.lagou.demo.service.impl;

import com.lagou.demo.service.IDemoService;
import com.lagou.mvcframework.annotation.LagouService;

@LagouService
public class DemoServiceImpl implements IDemoService {
    @Override
    public String get(String name) {
        System.out.println("service实现类中的name值：" + name);
        return name;
    }
}
