package 场景题;

public class BitMap {
    /**
     * 关于bitmap有两个不错的博文：
     * https://www.cnblogs.com/kubidemanong/p/9693686.html
     * http://www.manongjc.com/article/119021.html
     * <p>
     * 两个经典的问题分别对应bitmap, 2-bitmap
     * (1) 给40亿个不重复的unsigned int的整数，没排过序的，然后再给一个数，如何快速判断这个数是否在那40亿个数当中？
     * (2) 在2.5亿个整数找出不重复的整数，内存不足以容纳着2.5亿个整数
     * <p>
     * 在和面试官介绍的时候，可以这么说：
     * 三个数{1,2,4,5,6},检索一个数字是否存在
     * (1)直接遍历是O(N)的复杂度，复杂度太高，而且如果内存限制也不能一下子全部装进来
     * (2)接下来我们考虑，是不是可以把值当作下标来处理, 就相当于数组模拟hashmap，时间复杂度变成O(1)
     * 但是存储元素空间还是很大的，比如用boolean来存。boolean[] arr. 但是boolean还是占一个字节（存疑），8未有256可能，表示存在与否就比较浪费空间
     * （3）bitmap的思路就是一个数字存不存在其实两种可能，
     */

    /**
     * 用byte存，每一个byte就相当于数据桶，有8位
     */
    private byte arr[];
    private int capacity;

    public BitMap(int capacity) {
        this.capacity = capacity;
        // 一个byte可以表示8个数字
        arr = new byte[(capacity / 8 + 1)];
    }

    public void add(int n) {
        // 10/8 = 1在第一个桶
        int index = n >> 3;
        int position = n & 0x07;
        int val = 1 << position;
        arr[index] = (byte) (arr[index] | val);
    }

    public boolean contains(int n) {
        int index = n >> 3;
        int position = n & 0x07;
        // 其实就是查看这个位置上是不是1
        return (arr[index] & (1 << position)) != 0;
    }
}
