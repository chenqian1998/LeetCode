package lock;

public class Order {
    public  void pushOrder(){
        System.out.println(Thread.currentThread().getName()+":下订单");
    }

    public  void searchLib(){
        System.out.println(Thread.currentThread().getName()+":查询库存");
    }

    public  void confrimOrder(){
        System.out.println(Thread.currentThread().getName()+":确认订单");
    }
}
