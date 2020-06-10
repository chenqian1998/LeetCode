package structure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/4/16 11:26 下午
 * <p>
 * LRU 说的是在内存淘汰中的最近最久未使用算法，找到最久未使用的页面，进行淘汰
 * get(key):如果这个key是存在的，加到队列的尾部
 * put(key,value): 如果这个key存在，会更新然后加入队列尾部。否则就要把队列头部移除
 * <p>
 * 整个的数据结构应该是 数组 + 双向链表的方式。数组用来存储值，之后可以定义一个Node节点记录页面顺序
 */
public class LRU {
    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRU(LinkedHashMap<Integer, Integer> map, int capacity) {
        this.map = map;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        } else {
            // 不存在就返回-1
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            if (value == map.get(key)) {
                // 注意！使用了，一定要把这个值重新放到后面
                int val = map.get(key);
                map.remove(key);
                map.put(key, val);
            } else {
                map.remove(key);
                map.put(key, value);
            }
        } else {
            if (map.size() == capacity) {
                // 要删除最前面的一个元素再添加
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                Map.Entry<Integer, Integer> entry = iterator.next();
                int rmkey = entry.getKey();
                map.remove(rmkey);
                map.put(key, value);
            } else {
                map.put(key, value);
            }
        }
    }

    public void printCache() {
        System.out.println(map);
    }

    public static void main(String[] args) {
        LRU cache = new LRU(new LinkedHashMap<>(3),3);
        cache.put(1, 1);
        cache.put(1, 2);
        cache.printCache();

        cache.put(2, 2);
        cache.put(3, 3);
        cache.printCache();

        cache.put(1, 1);
        cache.printCache();

        cache.put(4, 4);
        cache.printCache();

        int[] arr = new int[10];
        int[] arr1 = {1, 2, 3, 4};

    }
}
