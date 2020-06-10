package Decorator;

public class EggDecorator extends AbstractDecorator {

    public EggDecorator(AbstractBatterCake abCake) {
        super(abCake);
    }

    @Override
    protected String getDecr() {
        return super.getDecr() + " 加一个鸡蛋 ";
    }

    @Override
    protected int getCost() {
        return super.getCost() + 1;
    }

    @Override
    public void doMoreThings() {
        System.out.println("增加了一个鸡蛋");
    }
}
