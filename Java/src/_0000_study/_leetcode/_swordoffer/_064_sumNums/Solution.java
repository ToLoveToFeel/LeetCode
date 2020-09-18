package _0000_study._leetcode._swordoffer._064_sumNums;

/**
 * Date: 2020/9/5 21:47
 * Content:
 */
class Solution {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n-1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println((new Solution()).sumNums(n));
    }
}
