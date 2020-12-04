package _0075_Sort_Colors;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 计数排序
 */
class Solution {

    public void sortColors(int[] nums) {

        int[] count = new int[3];  // 统计0,1,2的次数

        for (int num : nums) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++)
            for (int j = 0; j < count[i]; j++)
                nums[index++] = i;

    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        (new Solution()).sortColors(nums);

        for (int num : nums)
            System.out.println(num);
    }
}
