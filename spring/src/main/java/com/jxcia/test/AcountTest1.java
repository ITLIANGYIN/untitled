package com.jxcia.test;

import com.jxcia.factroy.BeanFactroy;
import com.jxcia.service.AcountService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class AcountTest1 {
    @Test
    public void acountTest(){
        //1.启动spring框架，控制台启动 ApplicationContext启动容器父类
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
//        AcountService as = (AcountService) ac.getBean("AcountService");
//       2. 根据名称和类型获取对象
        AcountService as =  ac.getBean("AcountService",AcountService.class);
//        3.方法调用
        as.addAcount();

    }
    //适合多例模式
    @Test
    public void test2(){
        Resource resource=new ClassPathResource("bean.xml");
        BeanFactory beanFactroy=new XmlBeanFactory(resource);
        AcountService as =  beanFactroy.getBean("AcountService",AcountService.class);
        AcountService as1 =  beanFactroy.getBean("AcountService",AcountService.class);
        System.out.println(as==as1);
    }
    @Test
    public void test3(){
        //从其他文件读取配置
        ApplicationContext ac=new FileSystemXmlApplicationContext("D:\\Idea\\ideaglc\\untitled\\spring\\src\\main\\resources\\bean.xml");
        AcountService ac1=ac.getBean("AcountService",AcountService.class);
        ac1.addAcount();
    }
}
