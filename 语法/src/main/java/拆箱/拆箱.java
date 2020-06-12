package 拆箱;

public class 拆箱 {
    public static void main(String[] args) {
        //
        /**
         将一个基本数据类型转换成对应的类(包装器类型) ==> 装箱
         装箱使用Integer.valueOf(int i)
         low = -128 high = 127

         public static Integer valueOf(int i) {
         if (i >= IntegerCache.low && i <= IntegerCache.high)
         // 会从缓存里面取，所以都是同一个对象
         return IntegerCache.cache[i + (-IntegerCache.low)];
         return new Integer(i);
         }
         */
        Integer i1 = 100;

        // 不会触发装箱
        Integer a = new Integer(10);
        // 将包装器类型转换成对应的基本数据类型
        int i = new Integer(10);
        System.out.println(i);

        // Q2: 解释下面代码结果
        // 下面四个都是会触发装箱的
        i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        // true
        System.out.println(i1 == i2);

        //false == > 这个不等是因为 1）== 是比较地址的
        // 2）在装箱时，调用了Integer.valueOf()方法，
        // 如果数字在 -128～127之间就直接调用 IntegerCache中缓存的Integer对象，
        // 所以其实i3 和 i4 不是一个对象
        System.out.println("i3 == i4 ? " + (i3 == i4));

        // Integer重写了equals()方法，变成比较这两个对象的值
        System.out.println(i3.equals(i4));


        // 当包装类 Integer类型与基本类型比较的时候，会自动进行拆箱
        System.out.println(i1 == 100);

        //只要有 + 就会自动拆箱
        System.out.println((i1 + i2) == i3);

    }
}
