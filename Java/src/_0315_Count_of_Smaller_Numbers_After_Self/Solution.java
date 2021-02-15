package _0315_Count_of_Smaller_Numbers_After_Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Date: 2021/2/15 22:18
 * Content: 树状数组
 * 执行用时：31 ms, 在所有 Java 提交中击败了27.80%的用户
 * 内存消耗：50.5 MB, 在所有 Java 提交中击败了16.41%的用户
 */
public class Solution {

    public static final int N = 20001;
    static int[] tr = new int[N + 1];

    private int lowbit(int x) {
        return x & -x;
    }

    private void add(int x, int v) {
        for (int i = x; i <= N; i += lowbit(i)) tr[i] += v;
    }

    private int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) res += tr[i];
        return res;
    }

    public List<Integer> countSmaller(int[] nums) {

        Arrays.fill(tr, 0);  // 必须加上，否则lc无法通过
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i] + 10001;
            res.add(query(x - 1));
            add(x, 1);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).countSmaller(new int[]{5, 2, 6, 1}));  // [2, 1, 1, 0]
        System.out.println((new Solution()).countSmaller(new int[]{-1, 0}));  // [2, 1, 1, 0]
    }
}
