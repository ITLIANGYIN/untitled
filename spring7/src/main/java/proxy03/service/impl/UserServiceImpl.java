package proxy03.service.impl;

import proxy03.pojo.User;
import proxy03.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public int addUser1(User user) {
        System.out.println("正在增加用户..."+user);
        return 1;
    }

    @Override
    public void addUser(User user) {
        System.out.println("正在增加用户..."+user);
    }
    @Override
    public int deleteUser(int id) {
        System.out.println("正在删除用户..."+id);
        return 1;
    }
}
