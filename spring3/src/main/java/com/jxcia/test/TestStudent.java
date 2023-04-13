package com.jxcia.test;

import com.jxcia.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ca=new ClassPathXmlApplicationContext("Student.xml");
        Student s1=ca.getBean("stu",Student.class);
        System.out.println(s1);
    }
}
