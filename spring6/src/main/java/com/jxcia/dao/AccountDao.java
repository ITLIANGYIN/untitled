package com.jxcia.dao;

import com.jxcia.pojo.Account;

import java.util.List;

public interface AccountDao {
   public int addAccount(Account account);
   List<Account> findAll();
}
