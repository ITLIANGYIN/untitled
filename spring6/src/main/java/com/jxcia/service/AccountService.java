package com.jxcia.service;

import com.jxcia.pojo.Account;

import java.util.List;

public interface AccountService {
    public int addAccount(Account account);
    List<Account> findAll();
}
