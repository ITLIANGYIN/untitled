package cn.jxcia.demo03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean03.xml");
        BookDao bookDao=ac.getBean("bookDao",BookDao.class);
        bookDao.save();
    }
}
