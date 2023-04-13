package cn.jxcia.demo02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean02.xml");
        BookService bookService= (BookService) ac.getBean("bookService");
        bookService.save();
    }
}
