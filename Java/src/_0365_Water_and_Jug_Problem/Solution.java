package _0365_Water_and_Jug_Problem;

/**
 * Date: 2021/5/12 15:43
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.3 MB, 在所有 Java 提交中击败了59.71%的用户
 */
public class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        return z == 0 || z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).canMeasureWater(3, 5, 4));  // true
        System.out.println((new Solution()).canMeasureWater(2, 6, 5));  // false
    }
}
