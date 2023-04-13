package com.jxcia.service.impl;

import com.jxcia.dao.AcountDao;
import com.jxcia.factroy.BeanFactroy;
import com.jxcia.service.AcountService;
public class AcountServiceImpl implements AcountService {
//    int count=1;
//    AcountDao ad= (AcountDao) BeanFactroy.getBean("AcountDao");
    AcountDao ad;
    public void init(){
        System.out.println("初始化");
    }
    public void destroy(){
        System.out.println("销毁");
    }
    public void setAd(AcountDao ad) {
        this.ad = ad;
    }
    String name;
    public void setName(String name) {
        this.name = name;
//        System.out.println(name);
    }
    public void addAcount(){
//        System.out.println(Thread.currentThread().getName()+"=="+(++count));
        System.out.println(name);
        ad.addAcount();

//        System.out.println("service层实现dao层逻辑");
    }
}
