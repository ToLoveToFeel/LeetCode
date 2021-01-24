package _0168_Excel_Sheet_Column_Title;

/**
 * Date: 2020/11/26 16:15
 * Content: 相当于进制转换，10进制转换为26进制(应该0-25对应'A'-'Z'，但是这里是1-26对应'A'-'Z')
 * 对于10进制数据：543
 * 543/10 = 54 ...... 3     得到个位
 * 54/10 = 5 ...... 4       得到十位
 * 5/10 = 0 ...... 5        得到百位
 * <p>
 * 对于26进制数据：1234
 * (1234-1)/26 = 47 ...... 11   得到个位 ('A'+11) = L
 * (47-1)/26 = 1 ...... 20      得到十位 ('A'+20) = U
 * (1-1)/26 = 0 ...... 0        得到百位 ('A'+0) = A
 * <p>
 * (701-1)/26 = 26 ...... 24    得到个位 ('A'+24) = Y
 * (26-1)/26 = 0 ...... 25      得到个位 ('A'+25) = Z  Z表示的是26，不是25
 * <p>
 * 对于26进制数据：701
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.6 MB, 在所有 Java 提交中击败了82.54%的用户
 * https://leetcode-cn.com/problems/excel-sheet-column-title/solution/qing-chu-zhe-liang-jian-shi-qi-shi-hen-jian-dan-de/
 */
public class Solution {

    // 十进制转化为 NBase 进制，A代表1...Z代表26
    public static final int NBase = 26;

    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            // 因为 Excel 取值范围为 1~26，故可将 26 进制 逻辑上的 个位、十位、百位…均减 1 映射到 0~25 即可，最后转换为字符
            n--;
            char c = (char) ((n % NBase) + 'A');
            sb.append(c);
            n /= NBase;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).convertToTitle(701));
    }
}
/*
 正常情况：二十六进制的范围是 0-25 ，所以除以 26 可以把 末尾元素 去掉，
 但这道题的范围是 1-26 即位上元素是A~Z，不存在0！
 为了转成我们熟悉的进制运算，我们需要把原本的数值减一进行运算
 这样原本的26减成了25，也就是Z('A'+25)，
 1减成了0,存入了A('A'+0)

 26 --------- Z --------- 'A'+ 25
 */
