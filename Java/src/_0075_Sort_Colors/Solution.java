package _0075_Sort_Colors;

class Solution {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    // 计数排序
    public void sortColors(int[] nums) {
        int[] count = new int[3];  // 统计0,1,2的次数
        for (int i = 0; i < 3; i++)
            count[i] = 0;

        for (int i = 0; i < nums.length; i++){
            if (!(nums[i] >= 0 && nums[i] <= 2))
                throw new IllegalArgumentException("Out of range [0..2]!");
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++)
            for (int j = 0; j < count[i]; j++)
                nums[index++] = i;

    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        (new Solution()).sortColors(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }
}
