package _0406_Queue_Reconstruction_by_Height;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/16 8:59
 * Content:
 * 执行用时：8 ms, 在所有 Java 提交中击败了90.65%的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了75.50%的用户
 */
public class Solution {

    public int[][] reconstructQueue(int[][] people) {

        if (people.length == 0 || people[0].length == 0)
            return new int[0][0];

        // 按照身高降序 K升序排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 如果身高相等(o1[0] == o2[0]) , 按照K降序排列(o2[0] - o1[0])
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });  // [[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]

        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {

        // [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = (new Solution()).reconstructQueue(people);

        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1)
                System.out.print(Arrays.stream(res[i]).boxed().collect(Collectors.toList()) + ", ");
            else
                System.out.print(Arrays.stream(res[i]).boxed().collect(Collectors.toList()));
        }
        System.out.print("]");
    }
}
