package _0842_Split_Array_into_Fibonacci_Sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/16 16:18
 * Content:
 * 回溯算法
 */
public class Solution {
    List<Integer> res;
    public static final int maxIntLength = 10;  // int最长为10位

    // S:输入的字符串，index:当前考察到的索引，pre1:前前一个数，pre2:前一个数，count:当前是第几个数
    // 从 index 开始寻找满足 num = pre1 + pre2 的第 count 个数据
    // 必须有返回值，这样才能保证 res.remove(res.size() - 1); 不是每次都运行
    private boolean dfs(String S, int index, int pre1, int pre2, int count) {
        if (index == S.length())
            return count >= 3;  // 两个数据不能称之为 Fibonacci 数列

        // 截取当前字符串，因为数据不大于 int 的最大值，i 代表当前数据的长度
        for (int i = 1; i <= maxIntLength; i++) {
            // 如果超出 S 的最大长度，或者以 0 开头并且位数大于 1，可以直接结束循环
            if (index + i > S.length() || (i > 1 && S.charAt(index) == '0'))
                break;

            String sub = S.substring(index, index + i);
            long numL = Long.parseLong(sub);

            // 判断 numL 是否超出 int 最大值；判断是否满足 Fibonacci 数列
            if (numL > Integer.MAX_VALUE || (count > 1 && numL > (pre1 + pre2)))
                break;

            int num = (int) numL;
            // 如果是前 2 个数，或者满足 Fibonacci 数列，递归进入下一层
            if (count < 2 || num == pre1 + pre2) {
                res.add(num);
                if(dfs(S, index + i, pre2, num, count + 1))
                    return true;
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    public List<Integer> splitIntoFibonacci(String S) {
        res = new ArrayList<>();
        dfs(S, 0, 0, 0, 0);
        return res;
    }

    public static void main(String[] args) {
//        String S = "123456579";
//        String S = "11235813";
//        String S = "112358130";
        String S = "0123";
        System.out.println((new Solution()).splitIntoFibonacci(S));
    }
}
