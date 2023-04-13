package demo06;

import java.io.Serializable;

//枚举真正单例
public enum Sun implements Serializable {
    INSTANCE1,INSTANCE2;
    private Sun() {
        System.out.println("枚举构造器");
    }
   public void show(){
       System.out.println("hello");
   }
}
