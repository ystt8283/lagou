package com.lagou.edu.utils;

import com.lagou.edu.annotation.Autoware;
import com.lagou.edu.annotation.Service;

import java.sql.SQLException;

/**
 * 事务管理器类：负责手动事务的开启，关闭，回滚
 *
 * 单例  恶汉式
 */
@Service("transactionManager")
public class TransactionManager {

    @Autoware("connectionUtils")
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void startTransaction() throws SQLException {
        connectionUtils.getCurrentThreadConn().setAutoCommit(false);
    }

    public void commit() throws SQLException {
        connectionUtils.getCurrentThreadConn().commit();
    }

    public void rollBack() throws SQLException {
        connectionUtils.getCurrentThreadConn().rollback();
    }
}
