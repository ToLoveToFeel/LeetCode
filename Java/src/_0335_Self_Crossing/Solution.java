package _0335_Self_Crossing;

/**
 * Created by WXX on 2021/2/27 10:09
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36 MB, 在所有 Java 提交中击败了17.31%的用户
 */
public class Solution {

    public boolean isSelfCrossing(int[] x) {

        if (x.length < 4) return false;
        for (int i = 3; i < x.length; i++) {
            if (x[i - 1] <= x[i - 3] && x[i] >= x[i - 2]) return true;
            if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) return true;
            if (i >= 5 && x[i - 3] >= x[i - 1] && x[i - 1] + x[i - 5] >= x[i - 3]
                    && x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isSelfCrossing(new int[]{2, 1, 1, 2}));  // true
    }
}
