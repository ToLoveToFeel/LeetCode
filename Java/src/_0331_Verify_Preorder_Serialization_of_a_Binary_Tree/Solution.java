package _0331_Verify_Preorder_Serialization_of_a_Binary_Tree;

/**
 * Created by WXX on 2021/2/26 10:20
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.2 MB, 在所有 Java 提交中击败了78.95%的用户
 */
public class Solution {

    int k = 0;
    char[] s;

    public boolean isValidSerialization(String _s) {

        _s = _s + ",";
        s = _s.toCharArray();
        if (!dfs()) return false;
        return k == s.length;
    }

    private boolean dfs() {
        if (k == s.length) return false;
        if (s[k] == '#') {
            k += 2;
            return true;
        }
        while (s[k] != ',') k++;
        k++;
        return dfs() && dfs();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));  // true
        System.out.println((new Solution()).isValidSerialization("1,#"));  // false
        System.out.println((new Solution()).isValidSerialization("9,#,#,1"));  // false
    }
}
