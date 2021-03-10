package _0682_Baseball_Game;

import java.util.LinkedList;

/**
 * Created by WXX on 2021/3/10 16:53
 * 执行用时：4 ms, 在所有 Java 提交中击败了19.05%的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了40.64%的用户
 */
public class Solution {

    public int calPoints(String[] ops) {

        LinkedList<Integer> stk = new LinkedList<>();
        for (String s : ops) {
            int p = stk.size() - 1;
            if (s.equals("+")) stk.add(stk.get(p) + stk.get(p - 1));
            else if (s.equals("D")) stk.add(2 * stk.get(p));
            else if (s.equals("C")) stk.removeLast();
            else stk.add(Integer.parseInt(s));
        }
        return stk.stream().reduce(Integer::sum).orElse(0);
    }

    public static void main(String[] args) {

        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println((new Solution()).calPoints(ops));  // 30
    }
}
