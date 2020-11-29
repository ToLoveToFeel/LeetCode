package _0258_Add_Digits;

/**
 * Date: 2020/11/29 14:39
 * Content:
 * https://blog.csdn.net/weixin_41541562/article/details/106635899
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.2 MB, 在所有 Java 提交中击败了97.55%的用户
 */
public class Solution2 {

    public int addDigits(int num) {

        return ((num - 1) % 9) + 1;
    }

    public static void main(String[] args) {

        int num = 38;  // 2
        System.out.println((new Solution2()).addDigits(num));
    }
}
