package _0202_Happy_Number;

import _0076_Minimum_Window_Substring.Solution2;

import java.util.HashSet;

public class Solution {
    // 时间复杂度：O(n * depth)
    // 空间复杂度：O(depth)
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        int num = nextNumber(n);
        while (!hashSet.contains(num)){
            hashSet.add(num);
            num = nextNumber(num);
        }
//        for (Integer e:hashSet)
//            System.out.println(e);
        return hashSet.contains(1);
    }

    private int nextNumber(int n){
        int ret = 0;
        while (n != 0){
            int temp = n % 10;
            n = n / 10;
            ret += temp * temp;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isHappy(19));
        System.out.println((new Solution()).isHappy(2));
    }
}
