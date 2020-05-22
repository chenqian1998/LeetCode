package Leetcode.JZOffer;

import java.util.HashMap;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/6
 * @description 找到第一个重复的数字，数组的长度是n,元素大小都是在0~n-1之间
 * 最大的特点还是最后两个特征，太明显了，一般这种条件都需要把元素值和下表联系起来
 */


public class p1 {
    public static int firstDuplicate(int[] arr, int n) {
        // 如果允许用hashmap,也就是空间复杂度 O(N)
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i< arr.length; i++){
            if (hashMap.containsKey(arr[i])){
                // hashMap.put(arr[i], hashMap.get(arr[i])+1);
                return arr[i];
            }else {
                hashMap.put(arr[i],1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int res = firstDuplicate(arr, arr.length);
        System.out.println(res);
    }
}
