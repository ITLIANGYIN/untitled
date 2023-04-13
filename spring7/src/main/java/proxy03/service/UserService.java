package proxy03.service;

import proxy03.pojo.User;

public interface UserService {
     int addUser1(User user);
     void addUser(User user);
     int deleteUser(int id);
}
