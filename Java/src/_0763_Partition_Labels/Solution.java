package _0763_Partition_Labels;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/10/22 9:03
 * Content:
 * 贪心算法、双指针
 * https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode-solution/
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];  // 记录每个字母最后出现的位置
        for (int i = 0; i < S.length(); i++)
            last[S.charAt(i) - 'a'] = i;

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;  // 每段分割的开始和结束位置 [start...end]
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);  // 更新结束位置
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println((new Solution()).partitionLabels(S));
    }
}
