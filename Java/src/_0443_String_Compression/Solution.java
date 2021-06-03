package _0443_String_Compression;

/**
 * Date: 2021/6/3 15:05
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.38%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了55.72%的用户
 */
public class Solution {

    public int compress(char[] chs) {
        int k = 0;
        for (int i = 0; i < chs.length; i++) {
            int j = i;
            while (j < chs.length && chs[j] == chs[i]) j++;
            int len = j - i;
            chs[k++] = chs[i];
            if (len > 1) {
                int t = k;
                while (len > 0) {
                    chs[t++] = (char)('0' + len % 10);
                    len /= 10;
                }
                swap(chs, k, t - 1);
                k = t;
            }
            i = j - 1;
        }
        return k;
    }

    private void swap(char[] chs, int i, int j) {
        while (i < j) {
            char t = chs[i]; chs[i] = chs[j]; chs[j] = t;
            i++; j--;
        }
    }

    public static void main(String[] args) {

        char[] chs = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println((new Solution()).compress(chs));  // 6
    }
}
