package _0839_Similar_String_Groups;

/**
 * Date: 2021/6/6 14:56
 * 执行用时：98 ms, 在所有 Java 提交中击败了30.58%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了55.96%的用户
 */
public class Solution {

    static final int N = 310;

    int[] p = new int[N];

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        for (int i = 0; i < n; i++) p[i] = i;  // 并查集初始化
        int res = n;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int p1 = find(i), p2 = find(j);
                if (p1 != p2 && is_similar(strs[i].toCharArray(), strs[j].toCharArray())) {
                    p[p1] = p2;
                    res--;
                }
            }
        return res;
    }

    private boolean is_similar(char[] a, char[] b) {
        int cnt = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) {
                cnt++;
                if (cnt > 2) return false;
            }
        return true;
    }

    public static void main(String[] args) {

        String[] strs = {"tars", "rats", "arts", "star"};  // 2
        System.out.println((new Solution()).numSimilarGroups(strs));
    }
}
