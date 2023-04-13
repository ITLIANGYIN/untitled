package cn.jxcia.factory;

import cn.jxcia.dao.UserDao;
import cn.jxcia.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
