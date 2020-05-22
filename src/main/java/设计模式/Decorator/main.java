package 设计模式.Decorator;



public class main {
    public static void main(String[] args) {
        AbstractBatterCake batterCake = new BatterCake();
        // 老千层饼了
        batterCake = new EggDecorator(batterCake);
        batterCake = new EggDecorator(batterCake);
        batterCake = new HotDogDecorator(batterCake);
        System.out.println(batterCake.getCost());
        System.out.println(batterCake.getDecr());

        System.out.println(batterCake.hashCode());
    }
}
