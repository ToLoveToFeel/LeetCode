package _0307_Range_Sum_Query_Mutable;

public class Solution {

    static class NumArray {

        private SegmentTree<Integer> seg;

        public NumArray(int[] nums) {
            if (nums.length > 0) {
                Integer[] data = new Integer[nums.length];
                for (int i = 0; i < nums.length; i++) data[i] = nums[i];
                seg = new SegmentTree<>(data, (a, b) -> a + b);
            }
        }

        public void update(int i, int val) {

            seg.set(i, val);
        }

        public int sumRange(int i, int j) {

            return seg.query(i, j);
        }
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);
        array.update(1, 2);
        System.out.println(array.sumRange(0, 2));  // 3
    }
}

