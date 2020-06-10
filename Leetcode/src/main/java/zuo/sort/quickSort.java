package zuo.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/15
 * @description
 */
public class quickSort {
    public int partition(int[] arr, int start, int end) {
        int pivot_val = arr[start];
        int i = start, j = end;
        while (i < j) {
            while (i<j && arr[j] >= pivot_val){
                j -= 1;
            }
            // 这里其实是赋值而不是交换
            arr[i] = arr[j];
            while (i<j && arr[i] <= pivot_val){
                i+= 1;
            }
            arr[j] = arr[i];

        }
        arr[i] = pivot_val;
        //System.out.println(Arrays.toString(arr));
        return i;
    }

    public void sortProcess(int[] arr, int start, int end){
        if (start < end){
            int index = partition(arr, start, end);
            sortProcess(arr,start,index-1);
            sortProcess(arr, index+1, end);
        }
    }

    @Test
    public void test01(){
        int[] arr = {5,2,1,4,3,0,1,1,1};
        sortProcess(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


}
