package _0386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/5/30 9:54
 */
public class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) dfs(i, n);
        return res;
    }

    private void dfs(int cur, int n) {
        if (cur <= n) res.add(cur);
        else return;
        for (int i = 0; i <= 9; i++) dfs(cur * 10 + i, n);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).lexicalOrder(13));
    }
}
