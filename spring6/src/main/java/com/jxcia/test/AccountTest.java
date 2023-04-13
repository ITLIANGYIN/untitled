package com.jxcia.test;

import com.jxcia.pojo.Account;
import com.jxcia.service.AccountService;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService as = context.getBean("accountService", AccountService.class);
        Account acount = new Account();
        acount.setName("张三");
        acount.setBalance(100.0f);
        int count = as.addAccount(acount);
        System.out.println(count > 0 ? "新增失败" : "新增成功");
        List<Account> accounts = as.findAll();
        for (Account a : accounts) {
            System.out.println(a);
        }
    }
}
