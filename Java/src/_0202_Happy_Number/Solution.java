package _0202_Happy_Number;

import java.util.HashSet;

/**
 * 时间复杂度：O(n * depth)
 * 空间复杂度：O(depth)
 */
public class Solution {

    public boolean isHappy(int n) {

        HashSet<Integer> hash = new HashSet<>();
        int num = nextNumber(n);
        while (!hash.contains(num)) {
            hash.add(num);
            num = nextNumber(num);
        }
        return hash.contains(1);
    }

    private int nextNumber(int n) {
        int res = 0;
        while (n != 0) {
            int t = n % 10;
            n = n / 10;
            res += t * t;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isHappy(19));  // true
        System.out.println((new Solution()).isHappy(2));  // false
    }
}
