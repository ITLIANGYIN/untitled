package com.jxcia.test;

import com.jxcia.dao.UserDao;
import com.jxcia.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ca=new ClassPathXmlApplicationContext("spring.xml");
        UserDao ud= ca.getBean("userDaoImpl",UserDao.class);
        ud.addUser(new User(111,"张三"));
    }
}
