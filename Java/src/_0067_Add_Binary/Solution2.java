package _0067_Add_Binary;

/**
 * 时间复杂度：O(max(len(a), len(b)))
 * 空间复杂度：O(1)
 */
public class Solution2 {

    public String addBinary(String a, String b) {

        // 转为字符数组
        StringBuilder sb = new StringBuilder();
        char[] res = (a.length() > b.length() ? a : b).toCharArray();
        char[] adder = (a.length() > b.length() ? b : a).toCharArray();

        // res加上adder，有些位置可能为2，之后出处理
        int index = res.length - 1;
        for (int i = adder.length - 1; i >= 0; i--) {
            res[index] += adder[i] - '0';
            index--;
        }

        // 处理进位问题
        for (int i = res.length - 1; i > 0; i--) {
            if (res[i] > '1') {
                res[i - 1] += 1;  // 进位
                res[i] = (char) ('0' + (res[i] - '0') % 2);
            }
        }
        if (res[0] > '1') {
            res[0] = (char) ('0' + (res[0] - '0') % 2);
            sb.append('1');
        }
        sb.append(res);
        return sb.toString();
    }

    public static void main(String[] args) {

        String a = "11";
        String b = "1";
        System.out.println((new Solution2()).addBinary(a, b));
    }
}
