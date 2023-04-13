package proxy05.test;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;
import proxy05.interceptor.ObjectInterceptor;
import proxy05.pojo.User;
import proxy05.service.impl.UserServiceImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class UserTest {
    @Test
    public void test1()  {
        // 在指定目录下生成动态代理类
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d://class");

        ObjectInterceptor h1 = new ObjectInterceptor();
//        CGLIB里提供的工具
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);//设置父类是谁
        enhancer.setCallback(h1);//设置拦截器
        UserServiceImpl us = (UserServiceImpl) enhancer.create();//创建子类对象
        User user = new User(111, "张三");
        int count = us.addUser1(user);
        System.out.println(count > 0 ? "新增成功" : "新增失败");
        System.out.println("========>");
        int count1 = us.deleteUser(111);
        System.out.println(count1 > 0 ? "删除成功" : "删除失败");
    }
}
