package _1486_XOR_Operation_in_an_Array;

/**
 * Date: 2021/5/7 11:44
 */
public class Solution {

    public int xorOperation(int n, int start) {
        return (sum(start / 2 - 1) ^ sum(start / 2 + n - 1)) * 2 + (n & start & 1);
    }

    // sum(x)=0^1^2^...^x
    private int sum(int x) {
        if (x % 4 == 0) return x;
        if (x % 4 == 1) return 1;
        if (x % 4 == 2) return x + 1;
        return 0;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).xorOperation(5, 0));
        System.out.println((new Solution()).xorOperation(4, 3));
        System.out.println((new Solution()).xorOperation(1, 7));
    }
}
