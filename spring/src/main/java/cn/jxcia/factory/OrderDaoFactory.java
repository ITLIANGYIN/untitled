package cn.jxcia.factory;

import cn.jxcia.dao.OrderDao;
import cn.jxcia.dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
        System.out.println("factory setup ....");
        return new OrderDaoImpl();
    }
}
