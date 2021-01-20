package _0628_Maximum_Product_of_Three_Numbers;

/**
 * Date: 2020/11/22 9:57
 * Content: 暴力解法
 * 时间复杂度：O(n + k*log(n))
 * 空间复杂度：O(n)
 * <p>
 * 思路：classicalproblems 中的 FindTopKMax 锦标赛法
 * <p>
 * 执行用时：3 ms, 在所有 Java 提交中击败了82.36%的用户
 * 内存消耗：39.6 MB, 在所有 Java 提交中击败了95.97%的用户
 * <p>
 * 思路：另外还可以用优先队列解决该问题，这里就不写Solution4
 */
public class Solution3 {

    // 会改变newNums的内容，这是必要的
    private int findMax(int[] newNums, int index) {

        // 完全二叉树，左孩子为奇数节点，右孩子为偶数节点
        while (index > 0) {
            int ai;  // 另一个孩子所在节点的位置
            if ((index & 1) == 1) ai = index + 1;  // 说明index对应的节点是左孩子
            else ai = index - 1;

            int pi = (index - 1) / 2;  // 父节点的位置
            newNums[pi] = Math.max(newNums[index], newNums[ai]);

            index = pi;
        }
        return newNums[0];
    }

    private int[] findTopKMax(int[] nums, int K) {

        int n = nums.length;
        if (n <= 0 || n < K) throw new IllegalArgumentException("参数错误");

        int[] res = new int[K];  // 存储结果
        int index = -1;  // index = 1, 代表已经求得最大值和第二大的数据

        // 第一步：开辟新数组，将原始数组中的数据移到新数组尾部
        int[] t = new int[2 * n - 1];
        for (int i = 0; i < nums.length; i++) t[i + n - 1] = nums[i];

        // 第二步：自底向上，寻找最大值
        for (int i = n - 2; i >= 0; i--) t[i] = Math.max(t[2 * i + 1], t[2 * i + 2]);

        res[++index] = t[0];

        // 第三步：循环 K-1 次，找到其余的结果
        for (int i = 0; i < K - 1; i++) {
            // 3.1 自上而下，找到此时的最大值在叶节点的位置，然后置为无穷小
            int maxIndex = 0;  // 最大值所在的索引位置
            while (maxIndex <= n - 2) {
                int leftIndex = 2 * maxIndex + 1;
                int rightIndex = 2 * maxIndex + 2;
                if (t[leftIndex] == res[index]) {  // 说明左孩子为此时的最大值(可能已经有数据被置为无穷小了)
                    maxIndex = leftIndex;
                } else {  // 说明右孩子为此时的最大值
                    maxIndex = rightIndex;
                }
            }
            t[maxIndex] = Integer.MIN_VALUE;
            // 3.2 寻找此时的最大值，放入结果中
            res[++index] = findMax(t, maxIndex);
        }

        return res;
    }

    public int maximumProduct(int[] nums) {

        int n = nums.length;
        if (n < 3) throw new IllegalArgumentException("Input error!");

        // 寻找最大的三个元素
        int[] max = findTopKMax(nums, 3);
        // 寻找最小的二个元素
        for (int i = 0; i < n; i++) nums[i] = -nums[i];
        int[] min = findTopKMax(nums, 2);  // min中存储着两个最小值的相反数

        return Math.max(max[0] * max[1] * max[2], min[0] * min[1] * max[0]);
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};  // 24
//        int[] nums = {-100, -98, -1, 2, 3, 4};  // 39200
        System.out.println((new Solution3()).maximumProduct(nums));
    }
}
