package _0303_Range_Sum_Query_Immutable;

public class Solution {

    static class NumArray {

        private SegmentTree<Integer> segmentTree;

        public NumArray(int[] nums) {

            if (nums.length > 0) {
                Integer[] data = new Integer[nums.length];
                for (int i = 0; i < nums.length; i++) data[i] = nums[i];
                segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
            }
        }

        public int sumRange(int i, int j) {

            return segmentTree.query(i, j);
        }
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);
        System.out.println(array.sumRange(2, 3));  // -2
    }
}

