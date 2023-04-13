package com.jxcia.dao.impl;

import com.jxcia.dao.UserDao;
import com.jxcia.datesource.DateSource;
import com.jxcia.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {
//    //不写byType(根据类型装配)
//    @Autowired
//    //按照名称
//    @Qualifier("dateSource")
    @Resource(name = "dateSource")
    DateSource dateSource=null;
    @Override
    public int addUser(User user) {
        System.out.println("连接数据库进行Address....");
        System.out.println(dateSource);
        System.out.println("数据源的URL是"+dateSource.getUrl());
        System.out.println("数据源的DriverClass是"+dateSource.getDriverClass());
        System.out.println("数据源的Username是"+dateSource.getUsername());
        System.out.println("数据源的Password是"+dateSource.getPassword());
        return 0;
    }
}
