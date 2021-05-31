package _0412_Fizz_Buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/5/31 17:27
 * 执行用时：7 ms, 在所有 Java 提交中击败了32.61%的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了53.81%的用户
 */
public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) res.add("FizzBuzz");
            else if (i % 3 == 0) res.add("Fizz");
            else if (i % 5 == 0) res.add("Buzz");
            else res.add("" + i);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).fizzBuzz(15));
    }
}
