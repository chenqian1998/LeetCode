package 设计模式.Decorator;

public class BatterCake extends AbstractBatterCake{
    @Override
    protected String getDecr() {
        return "煎饼";
    }

    @Override
    protected int getCost() {
        return 8;
    }
}
