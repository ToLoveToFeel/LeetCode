package _0119_Pascal_s_Triangle_II;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/21 18:48
 * Content:
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0)
            return res;

        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            long temp = ((long) res.get(i - 1)) * (rowIndex - i + 1) / i;
            res.add((int) temp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).getRow(0));
        System.out.println((new Solution()).getRow(3));
    }
}
