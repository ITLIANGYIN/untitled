package proxy01.test;

import org.junit.Test;
import proxy01.pojo.User;
import proxy01.service.UserService;
import proxy01.service.impl.UserServiceImpl;

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
