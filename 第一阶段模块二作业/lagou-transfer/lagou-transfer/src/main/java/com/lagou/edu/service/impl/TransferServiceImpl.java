package com.lagou.edu.service.impl;

import com.lagou.edu.annotation.Autoware;
import com.lagou.edu.annotation.Service;
import com.lagou.edu.dao.AccountDao;
import com.lagou.edu.dao.impl.JdbcAccountDaoImpl;
import com.lagou.edu.factory.BeanFactory;
import com.lagou.edu.service.TransferService;
import com.lagou.edu.pojo.Account;

@Service("transferService")
public class TransferServiceImpl implements TransferService {

    @Autoware("accountDao")
    private AccountDao accountDao = null;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {
        Account fromAccount = accountDao.queryAccountByCardNo(fromCardNo);
        Account toAccount = accountDao.queryAccountByCardNo(toCardNo);

        fromAccount.setMoney(fromAccount.getMoney() - money);
        toAccount.setMoney(toAccount.getMoney() + money);

        accountDao.updateAccountByCardNo(fromAccount);
        int t = 3/ 0;
        accountDao.updateAccountByCardNo(toAccount);
    }
}
