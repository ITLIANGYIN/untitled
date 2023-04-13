package proxy04.transaction;

public class Transaction {
    public void  open(){
        System.out.println("开启事务");
    }
    public void commit(){
        System.out.println("提交事务");
    }
}
