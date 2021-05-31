package _0405_Convert_a_Number_to_Hexadecimal;

/**
 * Date: 2020/10/3 16:58
 * Content:
 */
public class Solution {

    public String toHex(int num) {
        if (num == 0) return "0";
        char[] nums = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(nums[num & 0xf]);
            num >>>= 4;  // >>
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).toHex(26));
        System.out.println((new Solution()).toHex(0));
        System.out.println((new Solution()).toHex(-1));
    }
}
