package proxy05.interceptor;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import proxy05.service.impl.UserServiceImpl;
import proxy05.transaction.Transaction;
import java.lang.reflect.Method;
//拦截器
public class ObjectInterceptor implements MethodInterceptor {
    Transaction tx=new Transaction();

    /**
     *目标拦截方法
     * @param o 子类对象
     * @param method 代理类方法
     * @param objects 参数列表
     * @param methodProxy 父类方法(被代理类method)
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            Object res;
            tx.open();
//            目标对象
            res = methodProxy.invokeSuper(o, objects);
            tx.commit();
            return res;
    }
}
