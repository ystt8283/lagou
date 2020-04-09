package com.lagou.edu.utils;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.lagou.edu.annotation.Service;

import java.sql.Connection;
import java.sql.SQLException;

@Service("connectionUtils")
public class ConnectionUtils {

//    private ConnectionUtils() {
//
//    }
//
//    private static ConnectionUtils connectionUtils = new ConnectionUtils();
//
//    public static ConnectionUtils getInstance() {
//        return connectionUtils;
//    }
    //存储当前线程的连接
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    /**
     * 获得当前线程绑定的数据库连接
     * @return
     */
    public Connection getCurrentThreadConn() throws SQLException {
        Connection connection = threadLocal.get();
        if(connection == null) {
            //从连接池拿到数据库连接绑定到当前线程
            connection = DruidUtils.getInstance().getConnection();
            //绑定到当前线程的操作
            threadLocal.set(connection);
        }
        return connection;
    }
}
