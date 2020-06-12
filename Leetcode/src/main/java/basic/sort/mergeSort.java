package basic.sort;


import org.junit.Test;

import java.util.Arrays;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/15
 * @description
 * 归并排序的核心是：每次把数组分成两部分，每部分在他们自己的区间内是有序的。然后对这两部分进行合并且排序
 */
public class mergeSort {



    public void merge_sort(int[] arr){
        if (arr == null || arr.length <=1){
            return ;
        }
        merge_sort_core(arr, 0, arr.length-1);
    }

    private void merge_sort_core(int[] arr, int start, int end) {
        if (start < end){
            int mid = start + ((end- start)>>1);
            merge_sort_core(arr, start, mid);
            merge_sort_core(arr,mid+1, end);
            merge(arr,start,mid,end);
        }
    }

    /**
     * 以mid作为中点的数组，左边是arr[l,mid] ，右边是arr[mid+1,r],两边进行排序
     */
    private void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1<=mid && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }

        for (i = 0; i<help.length; i++){
            arr[l+i] = help[i];
        }
    }

    @Test
    public void test02(){
        int a = 4, b = 10;
        int mid = a + ((b-a)>>1);
        // 这个是错误的写法，>> 或者 << & | 这种位运算符的优先级比较低的
        // 所以，一定要加括号
        mid = a + (b-a)>>1;
        System.out.println(mid);
    }

    @Test
    public void test01(){
        int[] arr = {5,3,4,2,1};
        merge_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
