package proxy02.test;

import org.junit.Test;
import proxy02.pojo.User;
import proxy02.service.UserService;
import proxy02.service.impl.UserServiceImpl;

public class UserTest {
    @Test
    public void test1(){
        UserService user = new UserServiceImpl();
        User user1=new User(111,"张三");
        int count= user.addUser(user1);
        System.out.println(count>0?"新增成功":"新增失败");
        System.out.println("========>");
        int count1=user.deleteUser(111);
        System.out.println(count1>0?"删除成功":"删除失败");
    }
}
