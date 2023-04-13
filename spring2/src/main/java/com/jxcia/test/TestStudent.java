package com.jxcia.test;

import com.jxcia.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    @Test
    public void test1(){
       ClassPathXmlApplicationContext ca =new ClassPathXmlApplicationContext("school.xml");
       Student stu= ca.getBean("stu", Student.class);
        System.out.println(stu);

        Student stu1= ca.getBean("stu1", Student.class);
        System.out.println(stu1);
        Student stu2= ca.getBean("stu2", Student.class);
        System.out.println(stu2);
    }
}
