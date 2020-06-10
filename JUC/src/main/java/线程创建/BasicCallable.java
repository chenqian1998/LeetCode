package 线程创建;


import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class job2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("___call___");
        return "success";
    }
}


public class BasicCallable {
    @Test
    public void test01() throws Exception {
        job2 call = new job2();
        FutureTask futureTask = new FutureTask(call);
        new Thread(futureTask, "callable").start();

    }
}
