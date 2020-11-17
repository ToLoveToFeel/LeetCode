package _0000_study.classicalproblems.findmaxsecondmax;

/**
 * Date: 2020/11/11 16:47
 * Content:
 */
public class FindMaxSecondMax {

    public int[] findMaxSecondMax(int[] nums) {

        int n = nums.length;

        assert n >= 1;  // 数组中至少要有一个元素
        if (n == 1)
            return new int[]{nums[0], nums[0]};

        // 第一步：开辟新数组，将原始数组中的数据移到新数组尾部
        int[] newNums = new int[2 * n - 1];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + n - 1] = nums[i];
        }

        // 第二步：自底向上，寻找最大值
        for (int i = n - 2; i >= 0; i--) {
            newNums[i] = Math.max(newNums[2 * i + 1], newNums[2 * i + 2]);
        }
        int max = newNums[0];

        // 第三步：自顶向下，寻找次大值
        int secondMax = Integer.MIN_VALUE;
        int maxIndex = 0;  // 最大值所在的索引位置
        int index;  // nums[maxIndex] 的左右孩子中不是最大值的孩子的索引
        while (maxIndex <= n - 2) {

            int leftIndex = 2 * maxIndex + 1;
            int rightIndex = 2 * maxIndex + 2;
            if (newNums[leftIndex] > newNums[rightIndex]) {  // 说明左孩子为最大值，右孩子可能为次大值
                maxIndex = leftIndex;
                index = rightIndex;
            } else {  // 说明右孩子为最大值，左孩子可能为次大值
                maxIndex = rightIndex;
                index = leftIndex;
            }
            secondMax = Math.max(secondMax, newNums[index]);
        }

        return new int[]{max, secondMax};
    }

    public static void main(String[] args) {

//        int[] nums = {1};  // Max : 1 , SecondMax : 1
//        int[] nums = {3, 2, 6, 4};  // Max : 6 , SecondMax : 4
        int[] nums = {3, 2, 6, 4, 9};  // Max : 9 , SecondMax : 6
        int[] res = (new FindMaxSecondMax()).findMaxSecondMax(nums);

        System.out.print("Max : " + res[0] + " , SecondMax : " + res[1]);
    }
}
