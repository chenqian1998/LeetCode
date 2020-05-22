package 语法.BasicNumber;


import org.junit.Test;


public class 基本类型 {
    @Test
    // 整型
    public void test01() {
        // 用 8bit表示 == > 1 byte
        // -128 ～ 127
        byte b = 10;
        System.out.println(b);
        Byte b1 = new Byte((byte) 10);

        //大小 16bit == > 2 byte
        // -（2^15) ~ (2^15 - 1)
        short short_num = 1000;

        // 4 byte ==> 表示数字大小： -（2^31) ~ (2^31 -1) 也就是21亿多
        int a = 111111;
        Integer integer = new Integer(111);

        // 8 byte == >
        long long_num = 100l;
        Long l = new Long(long_num);

        // 转换规则
        int num1 = 100;
        long num2 = 10000;

        // 分为两种
        // 自动类型转换，是不需要我们进行操作的
        // 特点是高精度可以默认转化成低精度
        // int = long (把一个long类型赋值给int 是不行的）

        // num2 = num1; // 可以的

        // 强制类型转换会导致精度丢失！
        num1 = (int) num2;

        // java char默认占据2个字节
        // char在Java中是16位的，因为Java用的是Unicode
        //Java的Applet允许全世界范围内运行，那它就需要一种可以表述人类所有语言的字符编码：Unicode。
        char c = '陈';
        String s = "😊";
        char c2 = 'a';
        System.out.println(s);

    }

    @Test
    // 浮点型
    public void test02() {
        // 单精度 用32bit表示
        float f = 11.123f;
        Float f1 = new Float(f);


        // 双精度 用64bit表示
        double d = 111d;
    }
}
