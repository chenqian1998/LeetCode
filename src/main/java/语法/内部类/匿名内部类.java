package 语法.内部类;

public class 匿名内部类 {
    public static void main(String[] args) {
        final int a = 10;
        new Thread(() -> {
            // a = 100;
            // 匿名内部类只能使用外部final的属性

            System.out.println(a);
        }, "name").start();
    }
}
