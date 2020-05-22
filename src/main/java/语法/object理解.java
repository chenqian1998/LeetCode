package 语法;

import org.junit.Test;

interface Eatable{
    public void eat();
}

class Person implements Eatable{
    String name;
    int age;

    @Override
    public void eat() {
        System.out.println("the world!");
    }
}


public class object理解 {
    public static void main(String[] args) {
        Object object = new Object();
        // 首先说一个最不熟的，finalize()方法
        // 大致描述一下finalize流程：当对象变成(GC Roots)不可达时，
        // GC会判断该对象是否覆盖了finalize方法，若未覆盖，则直接将其回收。
        // 否则，若对象未执行过finalize方法，将其放入F-Queue队列
        // 其实就记这些就差不多
    }


    @Test
    public void test01() {
        Eatable p = new Person();
        p.eat();
    }
}
