package proxy02.service;

import proxy02.pojo.User;

public interface UserService {
     int addUser(User user);
     int deleteUser(int id);
}
