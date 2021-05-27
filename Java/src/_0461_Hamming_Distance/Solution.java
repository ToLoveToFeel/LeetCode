package _0461_Hamming_Distance;

/**
 * Date: 2021/5/27 9:00
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.3 MB, 在所有 Java 提交中击败了30.10%的用户
 */
public class Solution {

    public int hammingDistance(int x, int y) {
        int res = 0;
        for (int i = 30; i >= 0; i--)
            if (((x >> i & 1) ^ (y >> i & 1)) == 1)
                res++;
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).hammingDistance(1, 4));  // 2
    }
}
