package _0165_Compare_Version_Numbers;

/**
 * Date: 2021/1/24 11:11
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了87.79%的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了64.91%的用户
 */
public class Solution {

    public int compareVersion(String v1, String v2) {

        String[] t1 = v1.split("\\."), t2 = v2.split("\\.");
        for (int i = 0; i < t1.length || i < t2.length; i++) {
            int x = i < t1.length ? Integer.parseInt(t1[i]) : 0;
            int y = i < t2.length ? Integer.parseInt(t2[i]) : 0;
            if (x > y) return 1;
            if (x < y) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {

//        System.out.println((new Solution()).compareVersion("1.01", "1.001"));  // 0
        System.out.println((new Solution()).compareVersion("0.1", "1.1"));  // -1

    }
}
