package _0026_Remove_Duplicates_from_Sorted_Array;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int k = 1;  // [0...k)中的元素均为去重后的元素
        int removeValue = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] != removeValue){
                nums[k++] = nums[i];
                removeValue = nums[i];
            }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        System.out.println((new Solution()).removeDuplicates(nums));
    }
}
