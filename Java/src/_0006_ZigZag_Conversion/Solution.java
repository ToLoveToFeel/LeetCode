package _0006_ZigZag_Conversion;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/8/28 11:40
 * Content:
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }

        boolean down = false;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows-1)
                down = !down;
            curRow += (down ? 1 : -1);
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : list)
            res.append(row);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        System.out.println((new Solution()).convert(s, numRows));
    }
}
