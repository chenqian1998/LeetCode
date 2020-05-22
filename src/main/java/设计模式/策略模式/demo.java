package 设计模式.策略模式;


interface RewardStrategy{
    public void reward();
}

class NewUserRewardStrategy implements RewardStrategy{

    @Override
    public void reward() {
        System.out.println("给新用户奖励");
    }
}

class OldUserRewardStrategy implements RewardStrategy{

    @Override
    public void reward() {
        System.out.println("给老用户奖励");
    }
}

// 抽象工厂
interface StrategyFactory{
    public RewardStrategy createStrategy(Class c);
}

class FactorRewardStrategyFactory implements StrategyFactory{
    @Override
    public RewardStrategy createStrategy(Class c) {
        RewardStrategy product = null;
        try {
            product = (RewardStrategy) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}


public class demo {
    public static void main(String[] args) {
        FactorRewardStrategyFactory factory = new FactorRewardStrategyFactory();
        RewardStrategy strategy = factory.createStrategy(OldUserRewardStrategy.class);
        strategy.reward();
    }
}
