package _0000_study.classicalproblems.findtopKmax;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/17 21:00
 * Content:
 */
public class FindTopKMax {

    private int findMax(int[] newNums, int index) {  // 会改变newNums的内容，这是必要的
        // 完全二叉树，左孩子为奇数节点，右孩子为偶数节点
        while (index > 0) {
            int anotherIndex;  // 另一个孩子所在节点的位置
            if ((index & 1) == 1)  // 说明index对应的节点是左孩子
                anotherIndex = index + 1;
            else
                anotherIndex = index - 1;
            int parentIndex = (index - 1) / 2;  // 父节点的位置
            newNums[parentIndex] = Math.max(newNums[index], newNums[anotherIndex]);

            index = parentIndex;
        }
        return newNums[0];
    }

    public int[] findTopKMax(int[] nums, int K) {

        int n = nums.length;

        if (n <= 0 || n < K)
            throw new IllegalArgumentException("参数错误");

        int[] res = new int[K];  // 存储结果
        int resIndex = -1;  // resIndex = 1, 代表已经求得最大值和第二大的数据

        // 第一步：开辟新数组，将原始数组中的数据移到新数组尾部
        int[] newNums = new int[2 * n - 1];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + n - 1] = nums[i];
        }

        // 第二步：自底向上，寻找最大值
        for (int i = n - 2; i >= 0; i--) {
            newNums[i] = Math.max(newNums[2 * i + 1], newNums[2 * i + 2]);
        }
        res[++resIndex] = newNums[0];

        // 第三步：循环 K-1 次，找到其余的结果
        for (int i = 0; i < K - 1; i++) {
            // 3.1 自上而下，找到此时的最大值在叶节点的位置，然后置为无穷小
            int maxIndex = 0;  // 最大值所在的索引位置
            while (maxIndex <= n - 2) {
                int leftIndex = 2 * maxIndex + 1;
                int rightIndex = 2 * maxIndex + 2;
                if (newNums[leftIndex] == res[resIndex]) {  // 说明左孩子为此时的最大值(可能已经有数据被置为无穷小了)
                    maxIndex = leftIndex;
                } else {  // 说明右孩子为此时的最大值
                    maxIndex = rightIndex;
                }
            }
            newNums[maxIndex] = Integer.MIN_VALUE;
            // 3.2 寻找此时的最大值，放入结果中
            res[++resIndex] = findMax(newNums, maxIndex);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 6, 4, 9};
        int K = 3;
        int[] res = (new FindTopKMax()).findTopKMax(nums, K);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }

}
