package 场景题;

public class HeapOOM {
    public static void main(String[] args) {
        String s = "";
        while (true) {
            s = s + "a";
            s = s.intern();
        }
    }
}
