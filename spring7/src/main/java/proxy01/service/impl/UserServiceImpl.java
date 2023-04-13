package proxy01.service.impl;

import proxy01.pojo.User;
import proxy01.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public int addUser(User user) {
        System.out.println("开启事务");
        System.out.println("正在增加用户..."+user);
        System.out.println("提交事务");
        return 1;
    }
    @Override
    public int deleteUser(int id) {
        System.out.println("开启事务");
        System.out.println("正在删除用户..."+id);
        System.out.println("提交事务");
        return 1;
    }
}
