package _0371_Sum_of_Two_Integers;

/**
 * Date: 2020/10/8 10:19
 * Content:
 */
public class Solution {
    public int getSum(int a, int b) {

        while (a != 0) {
            int x = a, y = b;
            a = ((x & y) << 1);
            b = (x ^ y);
        }
        return b;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).getSum(13, 11));
    }
}
