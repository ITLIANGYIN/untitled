package demo04;

import java.util.concurrent.TimeUnit;

public class VolatileDemoTest {
    int x = 0;
    //注意：这里的b没有被volatile修饰
    boolean b = false;
    /**
     * 对象的创建可能发生指令的重排序，使用 volatile 可以禁止指令的重排序，保证多线程环境内的系统安全。
     * 我们知道volatile关键字的作用是保证变量在多线程之间的可见性，
     * 它是java.util.concurrent包的核心，没有volatile就没有这么多的并发类给我们使用.
     * 正确的双重检查锁定模式需要需要使用`volatile`。volatile主要包含两个功能。
     * - 保证可见性。使用 volatile 定义的变量，将会保证对所有线程的可见性。
     * - 禁止指令重排序优化。
     * 由于 volatile 禁止对象创建时指令之间重排序，所以其他线程不会访问到一个未初始化的对象，从而保证安全性。
     * >注意，volatile禁止指令重排序在 JDK 5 之后才被修复
     */
//    volatile boolean b = false;//线程可见性，执行效率快
    /**
     * 写操作
     */
    private void write() {
        x = 5;
        b = true;
        System.out.println("x=>" + x);
        System.out.println("b =>" + b);
    }

    /**
     * 读操作
     */
    private void read() {
        int a=1;
        //如果b=false的话，就会无限循环，直到b=true才会执行结束，会打印出x的值
        while (!b) {
//            System.out.println(a++);
        }
        System.out.println("x=" + x);
    }

    public static void main(String[] args) throws Exception {
        final VolatileDemoTest volatileDemo = new VolatileDemoTest();

        //线程1执行写操作
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                volatileDemo.write();
            }
        });

        //线程2执行读操作
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                volatileDemo.read();
            }
        });

        //我们让线程2的读操作先执行
        thread2.start();

        //睡1毫秒，为了保证线程2比线程1先执行
        TimeUnit.MILLISECONDS.sleep(1);

        //再让线程1的写操作执行
        thread1.start();

        //等待线程1和线程2全部结束后，打印执行结束
        System.out.println("执行结束");
    }
}
