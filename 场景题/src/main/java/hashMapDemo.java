public class hashMapDemo {
    // 数据桶 node
    private String[] table;
    private int size;


    public hashMapDemo() {
        table = new String[16];
        size = 16;
    }

    public void push(String key, String value) {
        int hash = key.hashCode() & (size - 1);

    }

    public static void main(String[] args) {

    }
}
