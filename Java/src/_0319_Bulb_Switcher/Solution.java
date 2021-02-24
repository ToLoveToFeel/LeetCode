package _0319_Bulb_Switcher;

/**
 * Date: 2021/2/24 10:01
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.2 MB, 在所有 Java 提交中击败了40.06%的用户
 */
public class Solution {

    public int bulbSwitch(int n) {

        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).bulbSwitch(3));  // 1
    }
}
