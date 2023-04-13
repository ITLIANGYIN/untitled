package com.jxcia.test;

import com.jxcia.pojo.Man;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMan {
    @Test
    public void test1() {
    ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("man.xml");
    Man man = ca.getBean("m", Man.class);
        System.out.println(man);
}
}
