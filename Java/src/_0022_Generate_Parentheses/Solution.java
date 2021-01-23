package _0022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/15 10:44
 * Content:
 * 回溯算法
 */
public class Solution {

    ArrayList<String> res = new ArrayList<>();

    // sb：待生成的括号；leftNum、rightNum：左右括号可用的个数；n：括号对数
    private void generateParenthesis(StringBuilder sb, int leftNum, int rightNum, int n) {

        if (leftNum == n && rightNum == n) {
            res.add(sb.toString());
            return;
        }

        if (leftNum < n) {
            sb.append('(');
            generateParenthesis(sb, leftNum + 1, rightNum, n);
            sb.deleteCharAt(sb.length() - 1);  // 回溯
        }
        if (leftNum > rightNum) {
            sb.append(')');
            generateParenthesis(sb, leftNum, rightNum + 1, n);
            sb.deleteCharAt(sb.length() - 1);  // 回溯
        }
    }

    public List<String> generateParenthesis(int n) {

        if (n <= 0) return res;
        StringBuilder sb = new StringBuilder();
        generateParenthesis(sb, 0, 0, n);
        return res;
    }

    public static void main(String[] args) {

        int n = 3;
        System.out.println((new Solution()).generateParenthesis(n));
    }
}
