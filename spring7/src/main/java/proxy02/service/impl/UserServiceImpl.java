package proxy02.service.impl;

import proxy02.pojo.User;
import proxy02.service.UserService;
import proxy02.transaction.Transaction;

public class UserServiceImpl implements UserService {
    Transaction tx=new Transaction();
    @Override
    public int addUser(User user) {
        tx.open();
        System.out.println("正在增加用户..."+user);
        tx.commit();
        return 1;
    }
    @Override
    public int deleteUser(int id) {
        tx.open();
        System.out.println("正在删除用户..."+id);
        tx.commit();
        return 1;
    }
}
