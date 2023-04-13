package demo3;
//懒汉
public class Sun {
    //私有化构造方法
    private Sun(){

    }
    //线程可见volatile
    volatile private static Sun s=null;
    //同步代码块（同步方法效率低）

    /**
     * 这个方法首先判断变量是否被初始化，没有被初始化，再去获取锁。
     * 获取锁之后，再次判断变量是否被初始化。第二次判断目的在于有可能其他线程获取过锁，已经初始化改变量。
     * 第二次检查还未通过，才会真正初始化变量。
     * 这个方法检查判定两次，并使用锁，所以形象称为双重检查锁定模式。
     * 这个方案缩小锁的范围，减少锁的开销，看起来很完美。然而这个方案有一些问题却很容易被忽略。
     * @return
     */
    public static Sun getInstance(){
        if (s==null){
            //同步代码块,线程并发
            synchronized (Sun.class) {
                if (s==null) {
                    s = new Sun();
                }
            }
        }
        return s;
    }
}
