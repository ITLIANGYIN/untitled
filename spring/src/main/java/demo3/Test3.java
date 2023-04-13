package demo3;
//单例
import org.junit.Test;
public class Test3 extends Thread{
    @Override
    public void run() {
        System.out.println("对象地址："+Sun.getInstance()+"   hashCode："+Sun.getInstance().hashCode());
    }

    @Test
    public void testSun(){
        Test3[] thread=new Test3[20];
        for (int i=0;i<thread.length;i++){
            thread[i] = new Test3();
        }
        for (int i=0;i<thread.length;i++){
            thread[i].start();
        }
    }
}
