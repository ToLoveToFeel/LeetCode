package _0165_Compare_Version_Numbers;

/**
 * Date: 2021/1/24 11:11
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了87.79%的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了64.91%的用户
 */
public class Solution {

    public int compareVersion(String v1, String v2) {

        for (int i = 0, j = 0; i < v1.length() || j < v2.length(); ) {
            int a = i, b = j;
            while (a < v1.length() && v1.charAt(a) != '.') a++;
            while (b < v2.length() && v2.charAt(b) != '.') b++;
            int x = (a == i ? 0 : Integer.parseInt(v1.substring(i, a)));
            int y = (b == j ? 0 : Integer.parseInt(v2.substring(j, b)));
            if (x > y) return 1;
            if (x < y) return -1;
            i = a + 1;
            j = b + 1;
        }
        return 0;
    }

    public static void main(String[] args) {

        String v1 = "1.01";
        String v2 = "1.001";
        System.out.println((new Solution()).compareVersion(v1, v2));  // 0

    }
}
