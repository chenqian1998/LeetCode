package ExceptionDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo {
    /**
     * 问：上面的代码能编译通过吗？
     * 答：可以。ArithmeticException是RuntimeException异常，可以不进行捕获或抛出。 如果改为IOException
     */
    public int doSomething(){
        return 5 / 0;
    }

    /**
    问：它还能编译通过吗？
    答：不能。IOException是直接继承自Exception的异常，它必须得到处理，要么捕获要么抛出
     */
    public void doSomething2() throws IOException {
        InputStream is = new FileInputStream(new File("/Users/huangzx/test.txt"));
        is.read();
    }

    public static void main(String[] args) throws IOException {
        OutOfMemoryError error = new OutOfMemoryError();
        Demo demo = new Demo();
        //demo.doSomething();
        demo.doSomething2(); // 也就是说这里面编译器都会提醒你这里出错，不会让你运行的
        // 编译器不会检查RuntimeException异常
    }
}
