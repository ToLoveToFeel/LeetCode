package _0307_Range_Sum_Query_Mutable;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Integer[] nums1 = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums1, (a, b) -> a+b);
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0,5));

        NumArray obj = new NumArray(nums);
        obj.update(1,2);
        int param_1 = obj.sumRange(0,2);
        System.out.println(param_1);
    }
}
