package demo1;

import org.junit.Test;

public class Test01 extends Thread {
//    public void testSun(){
//        Sun sun=Sun.getInstance();//单例
//    }

    @Override
    public void run() {
        super.run();
        System.out.println("对象地址"+Sun.getInstance()+"----hashCode"+Sun.getInstance().hashCode());
    }
    @Test
    public void testSun(){
        Test01[] thread= new Test01[50];
        for(int i=0;i<thread.length;i++){
            thread[i] =new Test01();
        }
        for(int i=0;i<thread.length;i++){
            thread[i].start();
        }
    }
}
