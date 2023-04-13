package proxy04.test;

import org.junit.Test;
import proxy04.pojo.User;
import proxy04.interceptor.ObjectInterceptor;
import proxy04.service.UserService;
import proxy04.service.impl.UserServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class UserTest {
    @Test
    public void test1() {
        ObjectInterceptor h=new ObjectInterceptor();
//      Proxy. newProxyInstance()  使用反射方法动态生成一个代理类
//
        UserService userService=(UserService) Proxy.newProxyInstance
                (UserServiceImpl.class.getClassLoader(), UserServiceImpl.class.getInterfaces(),h);
        User user = new User(111, "张三");
        int count = userService.addUser1(user);
        System.out.println(count > 0 ? "新增成功" : "新增失败");
        userService.addUser(user);
        System.out.println("========>");
        int count1 = userService.deleteUser(111);
        System.out.println(count1 > 0 ? "删除成功" : "删除失败");
        saveProxyFile();
    }
    /**
     * 保存 JDK 动态代理生产的类
     * @param filePath 保存路径，默认在项目路径下生成 $Proxy0.class 文件
     */
    private static void saveProxyFile() {
        FileOutputStream out = null;
            try {
                byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0",
                        UserServiceImpl.class.getInterfaces());
                String path="d://class/$Proxy0.class";
                System.out.println(path);
                out = new FileOutputStream(path);
                out.write(classFile);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) {
                        out.flush();
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
