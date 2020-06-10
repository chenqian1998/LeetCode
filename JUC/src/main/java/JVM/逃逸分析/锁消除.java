package JVM.逃逸分析;

public class 锁消除 {
    public static void createObject() {
        synchronized (new Object()) {

        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            createObject();
        }
        System.out.println("cost = " + (System.currentTimeMillis() - start) + "ms");
    }
}
