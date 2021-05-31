package _0415_Add_Strings;

/**
 * Date: 2021/5/31 20:04
 */
public class Solution {

    public String addStrings(String a, String b) {
        char[] ca = new StringBuilder(a).reverse().toString().toCharArray();
        char[] cb = new StringBuilder(b).reverse().toString().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0, t = 0; i < ca.length || i < cb.length || t != 0; i++) {
            if (i < ca.length) t += ca[i] - '0';
            if (i < cb.length) t += cb[i] - '0';
            sb.append(t % 10);
            t /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).addStrings("11", "123"));  // 134
    }
}
