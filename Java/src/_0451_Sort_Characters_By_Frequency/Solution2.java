// Author  :  Wang Xiaoxiao
// Time    :  2020-01-26
package _0451_Sort_Characters_By_Frequency;

import java.util.PriorityQueue;  // 默认小顶堆

public class Solution2 {
    public String frequencySort(String s) {
        // 第一步：统计各个字母出现的次数
        int[] letters = new int[128];
        for (char c : s.toCharArray()) {
            letters[c]++;
        }

        // 第二步：创建优先队列
        PriorityQueue<Character> queue = new PriorityQueue<>(128, (a, b) -> Integer.compare(letters[b], letters[a]));
        for (int i = 0; i < 128; i++) {
            if (letters[i] != 0)
                queue.add((char) i);
        }

        // 第三步：从优先队列中取出元素，第一个元素出现的次数最多，得到答案
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.remove();
            while (letters[c]-- > 0)
                sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Solution2()).frequencySort("tree"));
        System.out.println((new Solution2()).frequencySort("cccaaa"));
        System.out.println((new Solution2()).frequencySort("Aabb"));
    }
}
