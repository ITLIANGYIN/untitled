package demo06;

import demo05.Test;

public class Test06 extends Thread{
    @Override
    public void run() {
        System.out.println(Sun.INSTANCE1);
        System.out.println(Sun.INSTANCE1.hashCode());
    }

    public void TEnum(){
        Test06[] thread=new Test06[5];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Test06();
        }
        for (int i = 0; i < thread.length; i++) {
            thread[i].start();
        }
    }
}
