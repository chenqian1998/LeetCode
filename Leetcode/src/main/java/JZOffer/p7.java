package JZOffer;


import structure.TreeNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/6
 * @description
 */
public class p7 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] mid) {
        return null;
    }

    public TreeNode core(int[] pre, int preStart, int preEnd, int[] mid, int midStart, int midEnd) {
        if (preStart > preEnd || midStart > midEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);

        // 找到mid数组中 pre[preStart] 的位置
        for(int i =midStart; i<= midEnd;i++){
            if (pre[preStart] == mid[i]){
                int length = i - midStart;
                root.left = null;
            }
        }
        return root;

    }


}
