package _0888_Fair_Candy_Swap;

import _0000_study._common.Output;

import java.util.HashSet;

/**
 * Date: 2021/2/2 19:41
 * Content:
 * A、B交换x,y后，要达到 sumA - x + y = sumB + x - y, 所以：x = y + (sumA - sumB) / 2
 * 执行用时：12 ms, 在所有 Java 提交中击败了62.27%的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了76.92%的用户
 */
public class Solution {

    public int[] fairCandySwap(int[] A, int[] B) {

        long sumA = 0, sumB = 0;
        for (int x : A) sumA += x;
        for (int y : B) sumB += y;

        HashSet<Integer> hash = new HashSet<>();
        for (int x : A) hash.add(x);

        for (int y : B) {
            int t = (int) (y + (sumA - sumB) / 2);
            if (hash.contains(t))
                return new int[]{t, y};
        }
        return new int[]{};
    }

    public static void main(String[] args) {

        int[] A = {1, 1}, B = {2, 2};
        Output.OutputBasicArray1D((new Solution()).fairCandySwap(A, B));  // [1, 2]
    }
}
