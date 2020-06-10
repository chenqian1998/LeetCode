package 状态模式;


import org.omg.CORBA.Request;

abstract class RewardState {
    abstract void doReward(RewardStateContext context, Request request);
}

class RewardStateContext {
    private RewardState rewardState;

    public void setRewardState(RewardState currentState) {
        this.rewardState = currentState;
    }

    public RewardState getRewardState() {
        return rewardState;
    }

    public void echo(RewardStateContext context, Request request) {
        rewardState.doReward(context, request);
    }
}


public class demo {
}
