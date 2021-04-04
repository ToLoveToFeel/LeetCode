package _0781_Rabbits_in_Forest;

import java.util.HashMap;

/**
 * Created by WXX on 2021/4/4 9:25
 * 执行用时：3 ms, 在所有 Java 提交中击败了68.18%的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了48.10%的用户
 */
public class Solution {

    public int numRabbits(int[] answers) {

        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int x : answers) cnt.put(x, cnt.getOrDefault(x, 0) + 1);

        int res = 0;
        for (Integer num : cnt.keySet()) {
            int t = cnt.get(num);  // t只兔子说自己有num个颜色相同的兔子
            res += (t + num) / (num + 1) * (num + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).numRabbits(new int[]{1, 1, 2}));  // 5
    }
}
