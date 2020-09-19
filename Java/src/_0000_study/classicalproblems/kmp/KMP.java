package _0000_study.classicalproblems.kmp;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/19 19:59
 * Content:
 */
public class KMP {
    private int[] getNext(String T) {
        int[] next = new int[T.length()];
        next[0] = -1;  // next[1] 一定为 0

        int i = 0, j = -1;
        while (i < T.length() - 1) {  // 这里 -1 的原因是因为当 i=T.length()-2 时，下面的循环一定会进入到 if 语句中，会使 i++
            if (j == -1 || T.charAt(i) == T.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public List<Integer> match(String S, String T) {
        List<Integer> res = new ArrayList<>();  // 存储匹配字符串的起始位置
        if (S.length() < T.length())
            return res;

        int[] next = getNext(T);  // 构造 next 表
        int i = 0, j = 0;  // 从起始开始匹配
        while (i < S.length()) {
            while (j < T.length()) {
                if (i >= S.length())  // 如果没有这个判断，String S = "ababababca"; String T = "ababab"; 这组测试会导致错误
                    break;
                if (j == -1 || S.charAt(i) == T.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];  // 更新 j 的值，如果匹配不成功，只需要更新 j 的值
                }
            }
            if (j == T.length()) {  // 此时说明全部匹配上
                res.add(i - j);
                // 此时寻找下一个我们可以需要将这次成功匹配视为不成功，因此只需要更新 j 的值
                i--;  // 仍要在前一个位置进行匹配
                j--;  // 需要矫正 j 的值，
                j = next[j];
            }
        }
        // 这种解法是只找第一次出现子串的位置
//        while (i < S.length() && j < T.length()) {
//            if (j < 0 ||  S.charAt(i) == T.charAt(j)) {
//                i++;
//                j++;
//            } else {
//                j = next[j];
//            }
//        }
//        res.add(j - i);
        return res;
    }

    public static void main(String[] args) {
//        String S = "ababababca";
//        String T = "ababab";
//        String S = "aa";
//        String T = "a";
        String S = "aaaaaaaaa";
        String T = "aa";
        List<Integer> res = (new KMP()).match(S, T);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
