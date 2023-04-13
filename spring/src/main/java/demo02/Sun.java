package demo02;
//懒汉
public class Sun {
    //私有化构造方法
    private Sun(){

    }
    private static Sun s=null;

    /**
     *这个例子在单线程环境交易正常运行，但是在多线程环境就有可能会抛出空指针异常。
     * 为了防止这种情况，我们需要使用 `synchronized` 。这样该方法在多线程环境就是安全的，
     * 但是这么做就会导致每次调用该方法获取与释放锁，开销很大。
     * @return
     */

    public synchronized static Sun getInstance(){
        if (s==null){
            s=new Sun();
        }
        return s;
    }
}
