package Decorator;

public class HotDogDecorator extends AbstractDecorator {

    public HotDogDecorator(AbstractBatterCake abCake) {
        super(abCake);
    }

    @Override
    public void doMoreThings() {
        System.out.println("加一根烤肠。");
    }

    @Override
    protected String getDecr() {
        return super.getDecr()+" 加一根烤肠 ";
    }

    @Override
    protected int getCost() {
        return super.getCost()+2;
    }
}
