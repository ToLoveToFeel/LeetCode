package _0393_UTF8_Validation;

/**
 * Date: 2020/9/13 16:06
 * Content: 位运算
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {

    public boolean validUtf8(int[] data) {

        int num = 0;  // 需要处理的字节数目，可以为0,1,2,3
        // 字节最高位和次高位掩码
        int mask1 = 1 << 7, mask2 = 1 << 6;
        for (int x : data) {
            if (num == 0) {  // 说明是一个新的字符需要处理
                int mask = 1 << 7;
                while ((mask & x) != 0) {
                    num++;
                    mask = mask >> 1;
                }
                if (num == 0) continue;  // 说明该UTF-8编码只有一位
                if (num > 4 || num == 1) return false;  // 最多前四位都是1，并且字符的开始不能是10
            } else if (!((x & mask1) != 0 && (x & mask2) == 0))  // 需要处理多个字节，判断后面的字节是否为10开头
                return false;
            num--;
        }
        return num == 0;
    }

    public static void main(String[] args) {

        int[] data = {197, 130, 1};
        System.out.println((new Solution()).validUtf8(data));
    }
}
