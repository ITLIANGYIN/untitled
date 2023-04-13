package proxy04.interceptor;
import proxy04.service.UserService;
import proxy04.service.impl.UserServiceImpl;
import proxy04.transaction.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//对象拦截器，实现反射接口
public class ObjectInterceptor implements InvocationHandler {
    Transaction tx=new Transaction();
    UserService us=new UserServiceImpl();
    /**
     * invoke 拦截方法
     * @param proxy 代理对象
     * @param method 目标方法
     * @param args 目标方法参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res;
        if ("deleteUser".equals(method.getName())){
            return method.invoke(us,args);
        }else {
            tx.open();
            res = method.invoke(us, args);
            tx.commit();
        }
        return res;
    }
}
