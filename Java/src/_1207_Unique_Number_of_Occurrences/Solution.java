package _1207_Unique_Number_of_Occurrences;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 2020/10/28 9:51
 * Content:
 * 哈希表
 * 执行用时：8 ms, 在所有 Java 提交中击败了5.55%的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了12.60%的用户
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];  // [-1000, 1000]
        for (int num : arr) {
            count[num + 1000]++;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 2000; i++) {
            if (set.contains(count[i])) {
                if (count[i] != 0)
                    return false;
            }
            set.add(count[i]);
        }

        return true;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 2, 1, 1, 3};  // true
//        int[] arr = {1, 2};  // false
        int[] arr = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};  // true
        System.out.println((new Solution()).uniqueOccurrences(arr));
    }
}
