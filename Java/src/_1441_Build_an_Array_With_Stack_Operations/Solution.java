package _1441_Build_an_Array_With_Stack_Operations;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/16 15:38
 * Content:
 */
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        if (target.length == 0)
            return res;

        // 每次考察前后两个元素，看两者的差距，比如 ：2,4  --> 差距为 4 - 2 - 1 = 1，需要添加一对 "Push", "Pop"
        int start, end = 0;
        for (int value : target) {
            start = end;
            end = value;

            int skips = end - start - 1;
            for (int j = 0; j < skips; j++) {  // 根据中间缺少数据的个数，增加 "Push", "Pop" 对
                res.add("Push");
                res.add("Pop");
            }
            res.add("Push");  // 当前考察数据需要推入
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] target = {1, 3};
//        int n = 3;
//        int[] target = {1, 2, 3};
//        int n = 3;
        int[] target = {1, 2};
        int n = 4;
        System.out.println((new Solution()).buildArray(target, n));
    }
}
