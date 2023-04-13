package proxy05.service.impl;

import proxy05.pojo.User;

public class UserServiceImpl  {


    public int addUser1(User user) {
        System.out.println("正在增加用户..."+user);
        return 1;
    }
    public void addUser(User user) {
        System.out.println("正在增加用户..."+user);
    }

    public int deleteUser(int id) {
        System.out.println("正在删除用户..."+id);
        return 1;
    }
}
