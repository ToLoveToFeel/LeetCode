package _0067_Add_Binary;

public class Solution2 {
    // 时间复杂度：O(max(len(a), len(b)))
    // 空间复杂度：O(1)
    public String addBinary(String a, String b) {
        // 转为字符数组
        StringBuilder sb = new StringBuilder();
        char[] res = (a.length() > b.length() ? a : b).toCharArray();
        char[] adder = (a.length() > b.length() ? b : a).toCharArray();
        // res加上adder，有些位置可能为2，之后出处理
        int index = res .length - 1;
        for (int i = adder.length - 1; i >= 0; i--){
            res[index] += adder[i] - '0';
            index--;
        }
        // 处理进位问题
        for (int i = res.length - 1; i > 0; i--)
            if (res[i] > '1'){
                res[i - 1] += 1;  // 进位
                res[i] = (char)('0' + (res[i] - '0') % 2);
            }
        if (res[0] > '1'){
            res[0] = (char)('0' + (res[0] - '0') % 2);
            sb.append('1');
        }
        sb.append(res);
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println((new Solution2()).addBinary(a, b));
    }
}
