package JVM.Reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class BasicSoft {
    private static final int _4M = 1024 * 1024 * 4;

    public static void main(String[] args) {
        soft();
    }

    public static void soft() {
        List<SoftReference<byte[]>> list = new ArrayList<>();
        List<SoftReference<byte[]>> list2 = new ArrayList<>();

        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        for (int i = 0; i < 5; i++) {
            // 关联了引用队列，如果软引用关联的byte[]数组被回收了，软引用会自动加到queue
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4M], queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }

        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null) {
            list.remove(poll);
            poll = queue.poll();
        }

        // 遍历list
        System.out.println("===========");
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }
}
