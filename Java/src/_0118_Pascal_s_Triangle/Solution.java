package _0118_Pascal_s_Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/21 16:59
 * Content:
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0)
            return res;
        if (numRows == 1) {
            res.add(new ArrayList<Integer>() {{
                add(1);
            }});
            return res;
        }
        // numRows一定大于等于2
        res.add(new ArrayList<Integer>(){{add(1);}});
        res.add(new ArrayList<Integer>(){{add(1); add(1);}});

        for (int i = 2; i < numRows; i++) {  // 从第三行开始填写
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < i - 1; j++)
                row.add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            row.add(1);
            res.add(row);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).generate(4));
    }
}
