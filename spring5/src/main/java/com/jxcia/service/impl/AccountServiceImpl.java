package com.jxcia.service.impl;

import com.jxcia.dao.AccountDao;
import com.jxcia.pojo.Account;
import com.jxcia.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public int addAccount(Account account) {
        return accountDao.addAccount(account);
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
