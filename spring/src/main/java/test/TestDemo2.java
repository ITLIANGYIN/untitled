package test;

import demo06.Sun;
import org.junit.Test;

import java.io.*;

public class TestDemo2 {
    @Test
    public void testD() throws Exception {
//        Sun sun=Sun.getInstance();
        Sun sun= Sun.INSTANCE1;
        //序列化
        OutputStream os=new FileOutputStream("sun.txt");
        ObjectOutputStream oos=new ObjectOutputStream(os);
        oos.writeObject(sun);
        System.out.println("序列化完毕");
        //反序列化
        InputStream is=new FileInputStream("sun.txt");
        ObjectInputStream ois=new ObjectInputStream(is);
        System.out.println("反序列化完毕");
        Sun sun2= (Sun) ois.readObject();
        System.out.println(sun.hashCode());
        System.out.println(sun2.hashCode());
        System.out.println(sun==sun2);
    }
}
