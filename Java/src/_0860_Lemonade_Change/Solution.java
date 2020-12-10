package _0860_Lemonade_Change;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2020/12/10 9:46
 * Content:
 * 执行用时：20 ms, 在所有 Java 提交中击败了6.51%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了95.25%的用户
 */
public class Solution {

    public boolean lemonadeChange(int[] bills) {

        int n = bills.length;

        if (n == 0)
            return true;

        // 存储当第 i 名顾客购买后，前 i - 1名顾客所得的各种面值的数量：(面值，数量)
        Map<Integer, Integer> map = new HashMap<>();
        // 依次考虑每位顾客
        for (int bill : bills) {

            if (bill == 5) {

                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bill == 10) {

                if (map.getOrDefault(5, 0) > 0) {
                    map.put(5, map.get(5) - 1);  // 找零
                    map.put(10, map.getOrDefault(10, 0) + 1);
                } else {  // 无法找零
                    return false;
                }
            } else {  // 说明是 20 面值

                if (map.getOrDefault(10, 0) > 0 && map.getOrDefault(5, 0) > 0) {
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
//                    map.put(20, map.getOrDefault(20, 0) + 1);
                } else if (map.getOrDefault(5, 0) >= 3) {
                    map.put(5, map.get(5) - 3);
//                    map.put(20, map.getOrDefault(20, 0) + 1);
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
        System.out.println((new Solution()).lemonadeChange(bills));
    }
}
