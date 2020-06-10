package structure;

public class BasicConcurrentHashMap {
    String[] table;

    int length;

    int size;

    public BasicConcurrentHashMap(int length) {
        this.length = length;
        this.size = 0;
    }

    public void put(String key, String val) {
        if (key == null || val == null) {
            throw new NullPointerException();
        }

        // 1、先定位到桶的下标
        int index = key.hashCode() & (length - 1);

        // 2、延迟初始化table
        if(table == null || table.length == 0){
            table = new String[length];
        }

        // 3、把数据放到index处
        // 区分是否有元素
        if (table[index] == null){
            // 使用CAS的方式加入元素
        }else {
            // 锁住的是这个位置的第一个节点,其实本质上是一个Node节点
            synchronized (table[index]){
                // 先不考虑链表转二叉树的情况
                // 遍历整个链表然后看有没有key情况是相等的，相等的化就是修改值，不想等的就是插入
            }
        }
    }
}
