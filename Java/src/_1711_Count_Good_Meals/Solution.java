package _1711_Count_Good_Meals;

import java.util.HashMap;

/**
 * Date: 2021/7/7 9:37
 * Content:
 * 执行用时：171 ms, 在所有 Java 提交中击败了45.08%的用户
 * 内存消耗：49.4 MB, 在所有 Java 提交中击败了37.96%的用户
 */
public class Solution {

    public int countPairs(int[] deliciousness) {
        int n = deliciousness.length;
        int mod = (int) (1e9) + 7;

        int[] s = new int[22];
        for (int i = 0, p = 1; i < 22; i++) {
            s[i] = p;
            p *= 2;
        }

        int res = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();  // (数字，出现次数)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 22; j++) {
                int t = s[j] - deliciousness[i];
                res = (res + hash.getOrDefault(t, 0)) % mod;
            }
            int d = deliciousness[i];
            hash.put(d, hash.getOrDefault(d, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] deliciousness = {1, 3, 5, 7, 9};
        System.out.println((new Solution()).countPairs(deliciousness));  // 4
    }
}
