package com.jxcia.test;

import com.jxcia.factroy.BeanFactroy;
import com.jxcia.service.AcountService;

/**
 * 单例模式(效率高，获取速度快)
 * 多次创建对象消耗性能，导致效率低一些
 * 获取速度比单例慢，单例除了第一次，以后都是从缓存中读取
 */
public class TestAcount {
    public static void main(String[] args) {
//        AcountService as= (AcountService) BeanFactroy.getBean("AcountService");
//        as.addAcount();
        T t=new T();
        for (int i=0;i<3;i++) {
            Thread t1 = new Thread(t, "线程"+i);
            t1.start();
        }
    }
}
class T implements Runnable{
    public void run() {
        AcountService as= (AcountService) BeanFactroy.getBean("AcountService");
        as.addAcount();
    }
}