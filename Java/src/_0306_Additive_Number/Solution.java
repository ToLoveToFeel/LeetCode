package _0306_Additive_Number;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/2/10 10:03
 * Content:
 * 执行用时：2 ms, 在所有 Java 提交中击败了25.32%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了9.49%的用户
 */
public class Solution {

    public boolean isAdditiveNumber(String num) {

        char[] nums = num.toCharArray();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j + 1 < nums.length; j++) {
                int a = -1, b = i, c = j;  // 第一个数：num[a+1,b]；第二个数：num[b+1,c]
                while (true) {
                    if ((b - a > 1 && nums[a + 1] == '0') || (c - b > 1 && nums[b + 1] == '0')) break;  // 有前导0
                    String x = num.substring(a + 1, b + 1), y = num.substring(b + 1, c + 1);
                    String z = add(x, y);
                    if (c + 1 + z.length() > num.length() || !num.substring(c + 1, c + 1 + z.length()).equals(z)) break;
                    a = b;
                    b = c;
                    c += z.length();
                    if (c + 1 == num.length()) return true;
                }
            }
        }
        return false;
    }

    // 高精度加法
    private String add(String x, String y) {
        List<Integer> A = new ArrayList<>(), B = new ArrayList<>(), C = new ArrayList<>();
        for (int i = x.length() - 1; i >= 0; i--) A.add(x.charAt(i) - '0');
        for (int i = y.length() - 1; i >= 0; i--) B.add(y.charAt(i) - '0');

        for (int i = 0, t = 0; i < A.size() || i < B.size() || t != 0; i++) {
            if (i < A.size()) t += A.get(i);
            if (i < B.size()) t += B.get(i);
            C.add(t % 10);
            t /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = C.size() - 1; i >= 0; i--) sb.append(C.get(i));
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isAdditiveNumber("1023"));  // false
        System.out.println((new Solution()).isAdditiveNumber("112358"));  // true
        System.out.println((new Solution()).isAdditiveNumber("199100199"));  // true
    }
}
