package _0227_Basic_Calculator_II;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * Created by WXX on 2021/3/11 9:35
 * 执行用时：16 ms, 在所有 Java 提交中击败了43.36%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了76.74%的用户
 */
public class Solution {

    Deque<Integer> nums = new ArrayDeque<>();
    Deque<Character> ops = new ArrayDeque<>();

    private void eval() {
        int b = nums.remove();
        int a = nums.remove();
        char c = ops.remove();

        int r;
        if (c == '+') r = a + b;
        else if (c == '-') r = a - b;
        else if (c == '*') r = a * b;
        else r = a / b;
        nums.push(r);
    }

    public int calculate(String s) {
        HashMap<Character, Integer> pr = new HashMap<>();
        pr.put('+', 1);
        pr.put('-', 1);
        pr.put('*', 2);
        pr.put('/', 2);
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            char c = a[i];
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                int j = i, t = 0;
                while (j < a.length && a[j] >= '0' && a[j] <= '9') t = t * 10 + (a[j++] - '0');
                nums.push(t);
                i = j - 1;
            } else {
                while (!ops.isEmpty() && pr.get(ops.peek()) >= pr.get(c)) eval();
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) eval();
        return nums.peek();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).calculate("3+2*2"));  // 7
        System.out.println((new Solution()).calculate("3/2"));  // 1
        System.out.println((new Solution()).calculate(" 3+5 / 2 "));  // 5
        System.out.println((new Solution()).calculate("1-1+1 "));  // 1
    }
}
