package _0514_Freedom_Trail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2020/11/11 10:22
 * Content: 深度遍历，遍历所有可能
 * 超出时间限制
 */
public class Solution {

    Map<Character, List<Integer>> map;  // 记录ring中的每个字符出现在ring中的下标位置

    /**
     * 当前12点对齐的是ring[ringIndex]，实现对齐key[keyIndex]到key末尾字符，所需的最少步数
     *
     * @param ring ring
     * @param key key
     * @param ringIndex 当前ring对应12:00位置的下标
     * @param keyIndex 当前key需要匹配字母的下标
     */
    private int dfs(String ring, String key, int ringIndex, int keyIndex) {
        if (keyIndex == key.length())
            return 0;

        char c = key.charAt(keyIndex);  // 当前需要对齐的字符
        int res = Integer.MAX_VALUE;
        for (Integer index : map.get(c)) {
            int step1 = Math.abs(ringIndex - index);  // 顺时针旋转需要旋转的次数
            int step2 = Math.abs(ring.length() - step1);  // 逆时针旋转需要旋转的次数
            int minStep = Math.min(step1, step2);
            res = Math.min(res, minStep + dfs(ring, key, index, keyIndex + 1));
        }
        return res;
    }

    public int findRotateSteps(String ring, String key) {

        map = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            if (!map.containsKey(c)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            } else {
                List<Integer> list = map.get(c);
                list.add(i);
                map.put(c, list);
            }
        }

        // 加上key.length()是因为每次都要按一下
        return dfs(ring, key, 0, 0) + key.length();
    }

    public static void main(String[] args) {

        String ring = "godding";
        String key = "gd";
        System.out.println((new Solution()).findRotateSteps(ring, key));
    }
}
