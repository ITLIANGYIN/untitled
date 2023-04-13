package demo05;

public class Test extends Thread {
    @Override
    public void run() {
            System.out.println("对象地址："+ Sun.getInstance()+"   hashCode："+ Sun.getInstance().hashCode());
    }
    @org.junit.Test
    public void SunTest() {
        Test[] thread = new Test[5];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Test();
        }
        for (int i = 0; i < thread.length; i++) {
            thread[i].start();
        }
    }
}
