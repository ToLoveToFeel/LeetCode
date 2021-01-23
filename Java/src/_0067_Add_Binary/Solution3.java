package _0067_Add_Binary;

/**
 * Date: 2020/12/7 11:27
 * Content: 模拟数学运算
 * 类似于Leetcode 0002 两数相加
 * 执行用时：2 ms, 在所有 Java 提交中击败了98.62%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了32.11%的用户
 */
public class Solution3 {

    public String addBinary(String a, String b) {

        // 第一步：翻转字符串，方便运算
        char[] s1 = new StringBuilder(a).reverse().toString().toCharArray();
        char[] s2 = new StringBuilder(b).reverse().toString().toCharArray();

        // 第二步：计算得到结果
        int t = 0;  // 保存进位
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length || i < s2.length; i++) {
            int va = (i >= s1.length ? 0 : s1[i] - '0');
            int vb = (i >= s2.length ? 0 : s2[i] - '0');
            int sum = va + vb + t;
            t = sum / 2;
            sum %= 2;
            sb.append(sum);
        }
        if (t != 0) sb.append(t);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String a = "11";
        String b = "1";
        System.out.println((new Solution3()).addBinary(a, b));
    }
}
