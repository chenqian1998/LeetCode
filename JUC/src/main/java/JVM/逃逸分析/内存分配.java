package JVM.逃逸分析;

import java.util.ArrayList;
import java.util.List;

public class 内存分配 {
    public static int i;

    public static void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
    }

    public static void main(String[] args) {
        test();
    }
}
