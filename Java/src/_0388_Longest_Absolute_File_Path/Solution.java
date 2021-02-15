package _0388_Longest_Absolute_File_Path;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2021/2/15 22:31
 * Content: 文件（文件夹也看成一种特殊的文件）的层次关系可以看成一棵树，假设树根位于第0层
 * 执行用时：1 ms, 在所有 Java 提交中击败了94.49%的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了56.30%的用户
 */
public class Solution {

    public int lengthLongestPath(String input) {

        Deque<Integer> stk = new ArrayDeque<>();  // 存储当前遍历的路径各个文件的长度
        int res = 0;
        char[] array = input.toCharArray();
        for (int i = 0, sum = 0; i < array.length; ) {
            int k = 0;  // 记录当前文件位于那一层
            while (i < array.length && array[i] == '\t') {
                i++;
                k++;
            }
            while (stk.size() > k) sum -= stk.remove();  // 第k层此时应该保留k个数据
            // 计算下一个文件的长度
            int j = i;
            while (j < array.length && array[j] != '\n') j++;
            int len = j - i;
            stk.push(len);
            sum += len;
            if (input.substring(i, j).contains("."))
                res = Math.max(res, sum + stk.size() - 1);
            i = j + 1;  // +1是为了跳过'\n'
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).lengthLongestPath(
                "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));  // 20
    }
}
