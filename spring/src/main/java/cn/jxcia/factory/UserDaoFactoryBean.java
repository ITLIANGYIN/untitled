package cn.jxcia.factory;

import cn.jxcia.dao.UserDao;
import cn.jxcia.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class UserDaoFactoryBean implements FactoryBean<UserDao> {
//代替原始实例工厂中创建对象的方法
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    public Class<?> getObjectType() {
        return UserDao.class;
    }

    public boolean isSingleton() {//默认单例模式
        return true;//true单例模式 false 非单例模式
    }
}
