package proxy03.proxy;

import proxy03.pojo.User;
import proxy03.service.UserService;
import proxy03.service.impl.UserServiceImpl;
import proxy03.transaction.Transaction;
//代理类
public class UserServiceImplProxy implements UserService {
    Transaction tx=new Transaction();
    UserService ui=new UserServiceImpl();
    @Override
    public int addUser1(User user) {
        tx.open();
        int count = ui.addUser1(user);
        tx.commit();
        return count;
    }
    @Override
    public void addUser(User user) {
        tx.open();
        ui.addUser(user);
        tx.commit();

    }
    @Override
    public int deleteUser(int id) {
        tx.open();
        int count= ui.deleteUser(id);
        tx.commit();
        return count;
    }
}
