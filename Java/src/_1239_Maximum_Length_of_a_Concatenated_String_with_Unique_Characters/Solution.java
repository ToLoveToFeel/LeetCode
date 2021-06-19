package _1239_Maximum_Length_of_a_Concatenated_String_with_Unique_Characters;

import _0000_study._common.Build;

import java.util.List;

/**
 * Date: 2021/6/19 9:51
 * 执行用时：2 ms, 在所有 Java 提交中击败了97.75%的用户
 * 内存消耗：35.9 MB, 在所有 Java 提交中击败了87.08%的用户
 */
public class Solution {

    int[] state;
    boolean[] st;  // st[i]=true说明arr[i]自身有重复元素
    int res = 0;

    public int maxLength(List<String> arr) {
        int n = arr.size();
        state = new int[n];
        st = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (char c : arr.get(i).toCharArray()) {
                int bit = 1 << (c - 'a');
                if ((state[i] & bit) != 0) {
                    st[i] = true;
                    break;
                }
                state[i] |= bit;
            }
        }
        dfs(arr, 0, 0, 0);
        return res;
    }

    void dfs(List<String> arr, int u, int cnt, int t) {
        if (u == arr.size()) {
            res = Math.max(res, cnt);
            return;
        }
        dfs(arr, u + 1, cnt, t);  // 不选arr[u]
        if ((t & state[u]) == 0 && !st[u]) {
            dfs(arr, u + 1, cnt + arr.get(u).length(), t | state[u]);  // 选arr[u]
        }
    }

    public static void main(String[] args) {

        List<String> arr = Build.build(new String[]{"un", "iq", "ue"});
        System.out.println((new Solution()).maxLength(arr));  // 4
    }
}
