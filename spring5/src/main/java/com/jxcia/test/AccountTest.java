package com.jxcia.test;

import com.jxcia.pojo.Account;
import com.jxcia.service.AccountService;
import com.jxcia.service.impl.AccountServiceImpl;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountTest {
    @Autowired
    AccountService as;
    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService as = context.getBean("accountServiceImpl", AccountServiceImpl.class);
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
@Test
public void test2(){
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
