package _0860_Lemonade_Change;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2020/12/10 9:46
 * Content: 查找表优化
 * 执行用时：2 ms, 在所有 Java 提交中击败了99.72%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了81.20%的用户
 */
public class Solution2 {

    public boolean lemonadeChange(int[] bills) {

        int n = bills.length;

        if (n == 0)
            return true;

        // 存储当第 i 名顾客购买后，前 i - 1名顾客所得的各种面值的数量：(面值，数量)
        // 0 : 代表面值为 5；1 : 代表面值为 10；2 : 代表面值为 20；
        int[] count = new int[2];

        // 依次考虑每位顾客
        for (int bill : bills) {

            if (bill == 5) {
                count[0]++;
            } else if (bill == 10) {
                if (count[0] > 0) {
                    count[0]--;  // 找零
                    count[1]++;
                } else {  // 无法找零
                    return false;
                }
            } else {  // 说明是 20 面值
                if (count[1] > 0 && count[0] > 0) {
                    count[1]--;
                    count[0]--;
                } else if (count[0] >= 3) {
                    count[0] -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

//        int[] bills = {5, 5, 5, 10, 20};  // true
//        int[] bills = {5, 5, 10};  // true
//        int[] bills = {10, 10};  // false
        int[] bills = {5, 5, 10, 10, 20};  // false
        System.out.println((new Solution2()).lemonadeChange(bills));
    }
}
