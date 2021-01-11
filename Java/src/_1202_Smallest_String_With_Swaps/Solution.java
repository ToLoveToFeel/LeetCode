package _1202_Smallest_String_With_Swaps;

import java.util.*;

/**
 * Date: 2021/1/11 11:12
 * Content:
 * 执行用时：62 ms, 在所有 Java 提交中击败了36.98%的用户
 * 内存消耗：87.8 MB, 在所有 Java 提交中击败了21.74%的用户
 */
public class Solution {

    public static final int N = 100010;

    static int[] p = new int[N];

    private static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int n = s.length();

        // 初始化并查集
        for (int i = 0; i < n; i++) p[i] = i;
        // 合并等价类
        for (List<Integer> pair : pairs) p[find(pair.get(0))] = find(pair.get(1));

        Map<Integer, LinkedList<Character>> t = new HashMap<>();
        // 将同一个并查集的顶点放在一起
        for (int i = 0; i < n; i++) {
            int tmp = find(i);
            if (t.containsKey(tmp)) t.get(tmp).add(s.charAt(i));
            else {
                LinkedList<Character> list = new LinkedList<>();
                list.add(s.charAt(i));
                t.put(tmp, list);
            }
        }
        // 集合中元素降序排列
        for (int i = 0; i < n; i++)
            if (t.containsKey(i))
                t.get(i).sort((o1, o2) -> -(o1 - o2));
        // 获得结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(t.get(p[i]).getLast());
            t.get(p[i]).removeLast();
        }
        return sb.toString();
    }

    private static List<List<Integer>> build(int[][] source) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            List<Integer> e = new ArrayList<>();
            for (int j = 0; j < source[i].length; j++) e.add(source[i][j]);
            res.add(e);
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] source = {{0, 3}, {1, 2}, {0, 2}};
        String s = "dcab";
        List<List<Integer>> pairs = build(source);
        System.out.println((new Solution()).smallestStringWithSwaps(s, pairs));
    }
}
