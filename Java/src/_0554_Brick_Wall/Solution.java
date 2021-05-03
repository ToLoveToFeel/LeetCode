package _0554_Brick_Wall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date: 2021/5/3 18:33
 */
public class Solution {

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (List<Integer> line : wall) {
            for (int i = 0, s = 0; i < line.size() - 1; i++) {
                s += line.get(i);
                hash.put(s, hash.getOrDefault(s, 0) + 1);
            }
        }

        int res = 0;  // 存储缝隙数量最大值
        for (int k : hash.keySet()) res = Math.max(res, hash.get(k));
        return wall.size() - res;
    }

    private static List<Integer> arrayToList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<List<Integer>> wall = new ArrayList<>();
        wall.add(arrayToList(new int[]{1, 2, 2, 1}));
        wall.add(arrayToList(new int[]{3, 1, 2}));
        wall.add(arrayToList(new int[]{1, 3, 2}));
        wall.add(arrayToList(new int[]{2, 4}));
        wall.add(arrayToList(new int[]{3, 1, 2}));
        wall.add(arrayToList(new int[]{1, 3, 1, 1}));
        System.out.println((new Solution()).leastBricks(wall));  // 2
    }
}
