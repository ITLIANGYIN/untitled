package cn.jxcia.test;

import cn.jxcia.dao.UserDao;
import cn.jxcia.factory.UserDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
//        UserDaoFactory userDaoFactory=new UserDaoFactory();
//        UserDao userDao=userDaoFactory.getUserDao();
//        userDao.save();
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) ac.getBean("userDao");
        UserDao userDao2= (UserDao) ac.getBean("userDao");
        System.out.println(userDao);
        System.out.println(userDao2);
        userDao.save();
    }
}
