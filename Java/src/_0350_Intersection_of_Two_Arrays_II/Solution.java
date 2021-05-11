package _0350_Intersection_of_Two_Arrays_II;

import _0000_study._common.Output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int x : nums1) hash.put(x, hash.getOrDefault(x, 0) + 1);
        for (int x : nums2) {
            if (hash.containsKey(x)) {
                res.add(x);
                hash.put(x, hash.get(x) - 1);
                if (0 == hash.get(x))
                    hash.remove(x);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 2, 1, 3, 3}, nums2 = new int[]{2, 3, 2};
        Output.OutputBasicArray1D((new Solution()).intersect(nums1, nums2));
    }
}
