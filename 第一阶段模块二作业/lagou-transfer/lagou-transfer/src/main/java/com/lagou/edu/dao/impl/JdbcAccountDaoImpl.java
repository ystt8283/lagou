package com.lagou.edu.dao.impl;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.lagou.edu.annotation.Autoware;
import com.lagou.edu.annotation.Service;
import com.lagou.edu.dao.AccountDao;
import com.lagou.edu.pojo.Account;
import com.lagou.edu.utils.ConnectionUtils;
import com.lagou.edu.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service("accountDao")
public class JdbcAccountDaoImpl implements AccountDao {

    @Autoware("connectionUtils")
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Override
    public Account queryAccountByCardNo(String cardNo) throws Exception {
//        Connection connection = DruidUtils.getInstance().getConnection();
        Connection connection = connectionUtils.getCurrentThreadConn();
        String sql = "SELECT * from t_lagou_account where card_no=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cardNo);
        ResultSet resultSet = preparedStatement.executeQuery();

        //封装结果集
        Account account = new Account();
        while (resultSet.next()) {
            account.setMoney(resultSet.getInt("money"));
            account.setCardNo(resultSet.getString("card_no"));
            account.setName(resultSet.getString("name"));
        }
        resultSet.close();
        preparedStatement.close();
        //
        //connection.close();
        return account;
    }

    @Override
    public int updateAccountByCardNo(Account account) throws Exception {
        Connection connection = connectionUtils.getCurrentThreadConn();
        String sql = "UPDATE t_lagou_account set money=? where card_no=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, account.getMoney());
        preparedStatement.setString(2,account.getCardNo());
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        //connection.close();
        return i;
    }
}
