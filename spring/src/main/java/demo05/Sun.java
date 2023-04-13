package demo05;

/**
 * 静态内部类
 */
public class Sun {
    private static Sun sun;
    //构造器私有化
    private Sun(){

    }
    static {
        sun=new Sun();
    }
//     static class MySingletonHandler{
//
//        private static Sun sun=new Sun();
//    }
    public static Sun getInstance() {
//        return MySingletonHandler.sun;
        return sun;
    }
}
