package 设计模式.Decorator;

public abstract class AbstractDecorator extends AbstractBatterCake{
    private AbstractBatterCake abCake;

    public AbstractDecorator(AbstractBatterCake abCake){
        this.abCake = abCake;
    }

    @Override
    protected String getDecr() {
        return abCake.getDecr();
    }

    @Override
    protected int getCost() {
        return abCake.getCost();
    }

    public abstract void doMoreThings();


}
