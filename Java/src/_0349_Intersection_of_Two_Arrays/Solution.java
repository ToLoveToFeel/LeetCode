package _0349_Intersection_of_Two_Arrays;

import _0000_study._common.Output;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> hash = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int x : nums1) hash.add(x);
        for (int x : nums2) {
            if (hash.contains(x)) {
                res.add(x);
                hash.remove(x);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 2, 1, 3, 3}, nums2 = new int[]{2, 3, 2};
        Output.OutputBasicArray1D((new Solution()).intersection(nums1, nums2));
    }
}
