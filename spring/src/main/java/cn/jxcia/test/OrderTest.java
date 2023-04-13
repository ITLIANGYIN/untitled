package cn.jxcia.test;

import cn.jxcia.dao.OrderDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderTest {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDao orderDao= (OrderDao) ac.getBean("orderDao");
        orderDao.save();
    }



}
