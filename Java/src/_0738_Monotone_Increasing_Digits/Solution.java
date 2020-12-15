package _0738_Monotone_Increasing_Digits;

/**
 * Date: 2020/12/15 9:12
 * Content:
 * https://leetcode-cn.com/problems/monotone-increasing-digits/solution/dan-diao-di-zeng-de-shu-zi-by-leetcode-s-5908/
 * 执行用时：1 ms, 在所有 Java 提交中击败了97.96%的用户
 * 内存消耗：35.4 MB, 在所有 Java 提交中击败了67.35%的用户
 */
public class Solution {

    public int monotoneIncreasingDigits(int N) {

        char[] array = Integer.toString(N).toCharArray();

        int i = 1;
        // [0...i-1]数字递增，array[i - 1] > array[i]
        // 以 N=24001为例：此时 i = 2
        while (i < array.length && array[i - 1] <= array[i]) {
            i++;
        }

        while (i < array.length) {
            // 从不满足条件的位置开始，依次向前（高位）将数据减一
            // 以 N=24001为例：运行完下面的语句后array : 2,3,0,0,1, 此时 i = 1
            while (i > 0 && array[i - 1] > array[i]) {
                array[i - 1] -= 1;
                i -= 1;
            }

            // 从 i+1开始，数据的低位全部置为 9 即可
            for (i += 1; i < array.length; i++) {
                array[i] = '9';
            }
        }

        return Integer.parseInt(new String(array));
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).monotoneIncreasingDigits(24001));  // 23999
    }
}
