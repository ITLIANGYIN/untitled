package demo1;

import java.io.Serializable;

//饿汉式
public class Sun implements Serializable {
    //私有化构造方法
    private Sun(){

    }
     private static Sun s=new Sun();//对外访问方法
    public static Sun getInstance(){
        return s;
    }

}
