package _1018_Binary_Prefix_Divisible_By_5;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/1/14 9:15
 * Content: 秦九韶算法
 * 执行用时：4 ms, 在所有 Java 提交中击败了92.76%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了14.54%的用户
 */
public class Solution {

    public List<Boolean> prefixesDivBy5(int[] A) {

        List<Boolean> res = new ArrayList<>();
        int t = 0;
        for (int num : A) {
            t = (t * 2 + num) % 5;
            res.add(t == 0);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {0, 1, 1, 1, 1, 1};
        System.out.println((new Solution()).prefixesDivBy5(A));
    }
}
