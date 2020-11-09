package _0973_K_Closest_Points_to_Origin;

import java.util.HashMap;
import java.util.PriorityQueue;  // 默认最小堆

/**
 * Date: 2020/11/9 9:24
 * Content:
 * 执行用时：90 ms, 在所有 Java 提交中击败了5.10%的用户
 * 内存消耗：47.3 MB, 在所有 Java 提交中击败了41.74%的用户
 */

public class Solution {

    private int distance(int x, int y) {
        return (x * x + y * y);
    }

    // 根据题目要求，输入一定合法，不需要进行合法性检查
    public int[][] kClosest(int[][] points, int K) {
        // 第一步：计算距离，存入map中(牵涉到相乘相加，需要考虑溢出问题，对于该问题，不存在溢出)
        HashMap<Integer, Integer> map = new HashMap<>(points.length);  // (点对下标, 距离)
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < 2; j++) {
                map.put(i, distance(points[i][0], points[i][1]));
            }
        }

        // 第二步：使用优先队列(最大堆)进行处理
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a, b) -> map.get(b) - map.get(a)
        );
        for (Integer key : map.keySet()) {
            if (queue.size() < K) {
                queue.add(key);
            } else if (map.get(key) < map.get(queue.peek())) {  // 比当前 K 个最小元素中的最大值小，更新
                queue.remove();
                queue.add(key);
            }
        }

        // 第三步：得到结果
        int[][] res = new int[K][2];
        int i = 0;
        while (!queue.isEmpty()) {
            int index = queue.remove();
            res[i][0] = points[index][0];
            res[i][1] = points[index][1];
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};  // [[-2, 4], [3, 3]]
//        int K = 2;
//        int[][] res = (new Solution()).kClosest(points, K);
        int[][] points = {{1, 3}, {-2, 2}};  // [[-2, 2]]
        int K = 1;
        int[][] res = (new Solution()).kClosest(points, K);

        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1)
                System.out.print("[" + res[i][0] + ", " + res[i][1] + "], ");
            else
                System.out.print("[" + res[i][0] + ", " + res[i][1] + "]");
        }
        System.out.print("]");
    }
}
