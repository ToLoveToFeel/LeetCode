package _0442_Find_All_Duplicates_in_an_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/6/2 20:38
 */
public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int x : nums) {
            int p = Math.abs(x) - 1;
            nums[p] *= -1;
            if (nums[p] > 0) res.add(Math.abs(x));
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));  // [2, 3]
    }
}
