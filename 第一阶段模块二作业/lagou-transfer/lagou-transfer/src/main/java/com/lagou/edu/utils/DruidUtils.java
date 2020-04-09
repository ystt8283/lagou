package com.lagou.edu.utils;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

public class DruidUtils {
    private DruidUtils() {

    }

    private static DruidDataSource druidDataSource = new DruidDataSource();

    static {
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://192.168.111.101:3306/lagou?useSSL=false&serverTimezone=Asia/Shanghai");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("Ystt_8283");
    }

    public static DruidDataSource getInstance() {
        return druidDataSource;
    }

}
