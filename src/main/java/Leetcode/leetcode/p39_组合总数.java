package Leetcode.leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/8
 * @description
 */
public class p39_组合总数 {

    public List<List<Integer>> combinationSum(int[] arr, int target) {

        // 这是一个使用DFS比较典型的问题，每个位置上都可以选择走或者不走,然后有一个最终结束的条件
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> pathes = new ArrayList<>();

        dfs(arr, arr.length - 1, 0, target, path, pathes);

        return pathes;

    }

    public void dfs(int[] arr, int n, int index, int remain, List<Integer> path, List<List<Integer>> pathes) {
        if (index > n || remain < 0) {
            return;
        }
        if (remain == 0){
            pathes.add(path);
            return;
        }

        // 选择这个位置走
        List<Integer> path1 = new ArrayList<>(path);
        path1.add(arr[index]);
        dfs(arr,n,index,remain-arr[index],path1,pathes);

        if (index < n){
            // 跳过这个位置
            dfs(arr, n, index+1, remain, path, pathes);
        }
    }

}
