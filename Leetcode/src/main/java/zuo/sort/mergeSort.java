package zuo.sort;


import org.junit.Test;
import utils.PrintUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/15
 * @description
 */
public class mergeSort {
    public void sortProcess(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        sortProcess(arr, l, mid);
        sortProcess(arr, mid+1, r);
        merge(arr,l,mid,r);
    }

    /**
     * 以mid作为中点的数组，左边是arr[l,mid) ，右边是arr[mid,r
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
    public void test(){
        int[] arr = {5,2,1,4,3};
        sortProcess(arr,0,arr.length-1);
        PrintUtil.print(arr);
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
}
