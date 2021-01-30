package _0201_Bitwise_AND_of_Numbers_Range;

/**
 * Date: 2021/1/30 15:07
 * Content:
 * 执行用时：6 ms, 在所有 Java 提交中击败了99.51%的用户
 * 内存消耗：37.8 MB, 在所有 Java 提交中击败了52.80%的用户
 */
public class Solution {

    public int rangeBitwiseAnd(int m, int n) {

        int res = 0;
        for (int i = 30; i >= 0; i--) {
            if ((m >> i & 1) != (n >> i & 1)) break;
            if ((m >> i & 1) == 1) res += 1 << i;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).rangeBitwiseAnd(5, 7));  // 4
    }
}
