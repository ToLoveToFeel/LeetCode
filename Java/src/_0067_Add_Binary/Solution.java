package _0067_Add_Binary;

public class Solution {

    // 这个解法是错误的，因为会越界
    public String addBinary(String a, String b) {
        // 将a,b转为十进制
        long a_ten = 0;
        for (int i = 0; i < a.length(); i++) {
            // a_ten = a_ten * 2 + Integer.parseInt(String.valueOf(a.charAt(i)));
            a_ten = a_ten * 2 + a.charAt(i) - '0';
        }
        long b_ten = 0;
        for (int i = 0; i < b.length(); i++)
            b_ten = b_ten * 2 + b.charAt(i) - '0';
        // 求和
        long sum = a_ten + b_ten;
        // 结果转化为二进制
        StringBuilder ret = new StringBuilder();
        while (sum != 0){
            ret.append(Long.toString(sum%2));
            sum /= 2;
        }
        return ret.toString().equals("") ? "0" : ret.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println((new Solution()).addBinary(a, b));
    }
}
