package demo02;


import org.junit.Test;

public class Test02 extends Thread {
//    public void testSun(){
//        Sun sun=Sun.getInstance();//单例
//    }

    @Override
    public void run() {
        super.run();
        System.out.println("对象地址："+ Sun.getInstance()+"----hashCode："+ Sun.getInstance().hashCode());
    }
    @Test
    public void testSun(){
        Test02[] thread= new Test02[100];
        for(int i=0;i<thread.length;i++){
            thread[i] =new Test02();
        }
        for(int i=0;i<thread.length;i++){
            thread[i].start();
        }
    }
}
