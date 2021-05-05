package _0241_Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/5/5 10:39
 */
public class Solution {

    List<String> expr = new ArrayList<>();

    public List<Integer> diffWaysToCompute(String s) {

        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                int j = i, x = 0;
                while (j < cs.length && cs[j] >= '0' && cs[j] <= '9')
                    x = x * 10 + (cs[j++] - '0');
                i = j - 1;
                expr.add(x + "");
            } else expr.add(s.substring(i, i + 1));
        }

        return dfs(0, expr.size() - 1);
    }

    private List<Integer> dfs(int l, int r) {
        if (l == r) return new ArrayList<Integer>(){{add(Integer.parseInt(expr.get(l)));}};

        List<Integer> res = new ArrayList<>();
        for (int i = l + 1; i < r; i += 2) {
            List<Integer> left = dfs(l, i - 1), right = dfs(i + 1, r);
            for (int x : left)
                for (int y : right) {
                    int z;
                    if (expr.get(i).equals("+")) z = x + y;
                    else if (expr.get(i).equals("-")) z = x - y;
                    else z = x * y;
                    res.add(z);
                }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).diffWaysToCompute("2-1-1"));
        System.out.println((new Solution()).diffWaysToCompute("2*3-4*5"));
    }
}
