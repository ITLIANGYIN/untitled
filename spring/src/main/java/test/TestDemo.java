package test;

import demo1.Sun;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class TestDemo {
    @Test
    public void t() throws Exception {
        Class<Sun> c=Sun.class;
        Constructor constructor=c.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object o1= constructor.newInstance();
        Object o2= constructor.newInstance();
//        Object o1= c.newInstance();
//        Object o2= c.newInstance();
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o1==o2);
    }
}
