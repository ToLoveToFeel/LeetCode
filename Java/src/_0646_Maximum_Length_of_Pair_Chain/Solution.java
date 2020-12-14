package _0646_Maximum_Length_of_Pair_Chain;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Date: 2020/12/14 16:20
 * Content: 贪心算法
 * <p>
 * 执行用时：10 ms, 在所有 Java 提交中击败了98.32%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了47.44%的用户
 */
public class Solution {

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);

        int res = 1;
        int end = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (end < pairs[i][0]) {
                res++;
                end = pairs[i][1];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] pairs = {{1, 2}, {2, 3}, {3, 6}};
        System.out.println((new Solution()).findLongestChain(pairs));
    }
}

/*
 证明贪心解的正确性，需要证明如下两个式子：
 (1) 贪心解 <= 最优解。            显然成立
 (2) 贪心解 >= 最优解。
    因为贪心解每次选择是符合条件的最小的右端点(假设是x2([x1,x2]))，则最优解中符合条件的右端点为y2([y1,y2])，
    则必定有y2>=x2，最优解中的下一个区间的左端点必定严格大于y2，此时就可以将最优解的[y1,y2]换为[x1,x2]，
    仍然符合条件，而且我们没有减少选择的区间的个数，因此我们可以一步一步将最优解转为贪心解，所以 贪心解 >= 最优解。
 */
