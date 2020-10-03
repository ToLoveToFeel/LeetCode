package _0405_Convert_a_Number_to_Hexadecimal;

/**
 * Date: 2020/10/3 16:58
 * Content:
 */
public class Solution {
    private static final int MASK = 0b1111;

    private char toSimpleHex(int num) {
        char c = '0';
        if (num < 10)
            c = (char) ('0' + num);
        else if (num < 16) {
            c = (char) ('a' + num - 10);
        }
        return c;
    }

    public String toHex(int num) {
        if (num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {  // int 为 32 位，每次处理 4 位，需要处理 8 次
            sb.append(toSimpleHex(num & MASK));
            num >>= 4;
        }

        sb = sb.reverse();
        // 处理多余的 0
        int start = 0;
        for (int i = 0; i < 8; i++) {
            if (sb.charAt(i) != '0') {
                start = i;
                break;
            }
        }

        return sb.substring(start);
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).toHex(26));
        System.out.println((new Solution()).toHex(0));
        System.out.println((new Solution()).toHex(-1));
    }
}
