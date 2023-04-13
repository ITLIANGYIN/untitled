package cn.jxcia.test;

import cn.jxcia.dao.BookDao;
import cn.jxcia.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {
    public static void main(String[] args) {
        //获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

//        BookDao bookDao=ac.getBean("bookDao",BookDao.class);
//        bookDao.save();
        BookService bookService=ac.getBean("bookService",BookService.class);
        bookService.save();;
    }
}
