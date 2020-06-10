package zuo.sort;


import org.junit.Test;
import utils.PrintUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/15
 * @description
 */
public class insertSort {
    // 5,2,1,4,3
    // 插入排序就是把后面元素的值放在前面位置，保持前面有序，后面无序
    public void insert_sort(int[] arr) {
        if (arr == null){
            return ;
        }
        int length = arr.length;
        if (length == 0) {
            return;
        }

        for (int i = 1; i < length; i++) {
            // 这里尤其要注意Java里面把 循环条件放在for循环里面
            // insertSort 如果是数组有序，那么一开始这个arr[j]>arr[j+1]就不满足，直接退出了
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test(){
        int[] arr = {5,2,1,4,3};
        insert_sort(arr);
        PrintUtil.print(arr);
    }
}
