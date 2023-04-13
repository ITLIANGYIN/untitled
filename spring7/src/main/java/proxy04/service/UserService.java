package proxy04.service;

import proxy04.pojo.User;

public interface UserService {
     int addUser1(User user);
     void addUser(User user);
     int deleteUser(int id);
}
