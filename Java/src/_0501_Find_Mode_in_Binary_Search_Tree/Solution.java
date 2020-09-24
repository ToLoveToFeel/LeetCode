package _0501_Find_Mode_in_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/24 9:09
 * Content:
 */
public class Solution {
    List<Integer> res = new ArrayList<>();
    int maxCount = 0;  // 众数出现的次数
    int preNum = 0;  // 上一个出现的数据
    int curCount = 0;  // 当前元素数据出现次数
    int curNum = 0;  // 当前考察数据的值

    private void dfs(TreeNode node) {
        if (node == null)
            return;

        dfs(node.left);

        // 第一步：统计当前考察数据出现次数
        curNum = node.val;
        if (curNum == preNum || curCount == 0) {  // 和之前的元素相等，或者是第一次出现
            curCount++;
        } else {
            curCount = 1;
        }
        // 第二步：比较当前数据是否大于之前众数出现的次数
        if (curCount > maxCount) {  // 当前考察数据出现的次数已经大于之前众数出现的次数
            res.clear();
            res.add(curNum);
            maxCount = curCount;
        } else if (curCount == maxCount) {
            res.add(curNum);
        }
        // 第三步：更新数据，方便下次比较
        preNum = curNum;

        dfs(node.right);
    }

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[]{};

        dfs(root);

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int nu = Integer.MIN_VALUE;  // 用Integer.MIN_VALUE表示二叉树 null
//        int[] nums = new int[]{
//                1,
//                nu, 2,
//                nu, nu, 2, nu,
//        };
        int[] nums = new int[]{
                7,
                3, 9,
                3, nu, 9, nu,
        };

        TreeNode root = (new MyTree(nums)).getRoot();
        int[] ret = (new Solution()).findMode(root);
        for (int num : ret) {
            System.out.println(num);
        }
    }
}
