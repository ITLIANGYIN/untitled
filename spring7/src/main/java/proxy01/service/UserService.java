package proxy01.service;

import proxy01.pojo.User;

public interface UserService {
     int addUser(User user);
     int deleteUser(int id);
}
