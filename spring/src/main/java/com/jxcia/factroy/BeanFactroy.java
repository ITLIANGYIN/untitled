package com.jxcia.factroy;


import com.jxcia.dao.AcountDao;

import java.io.IOException;
import java.util.Map;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactroy {
    //线安全Map
    static Map<String, Object> iocMap=new ConcurrentHashMap<String,Object>();
    static  {
        try {
            Properties properties=new Properties();
            properties.load(BeanFactroy.class.getClassLoader().getResourceAsStream("bean.properties"));
            String acountDao=properties.getProperty("AcountDao");
            Object acountDaoObj=Class.forName(acountDao).newInstance();
            iocMap.put("AcountDao",acountDaoObj);

            String acountService=properties.getProperty("AcountService");
            Object acountServiceObj=Class.forName(acountService).newInstance();
            iocMap.put("AcountService",acountServiceObj);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object getBean(String beanName){
        if (iocMap.containsKey(beanName)){
            return iocMap.get(beanName);
        }
        return null;
    }
}
