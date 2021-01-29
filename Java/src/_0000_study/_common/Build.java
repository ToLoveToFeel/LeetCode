package _0000_study._common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date: 2021/1/29 16:49
 * Content:
 */
public class Build {

    public static List<List<Integer>> build(int[][] source) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            List<Integer> e = new ArrayList<>();
            for (int j = 0; j < source[i].length; j++) e.add(source[i][j]);
            res.add(e);
        }
        return res;
    }

    public static List<String> build(String[] s) {
        List<String> res = new ArrayList<>();
        Collections.addAll(res, s);
        return res;
    }

    public static List<List<String>> build(String[][] s) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            List<String> e = new ArrayList<>();
            for (int j = 0; j < s[i].length; j++) e.add(s[i][j]);
            res.add(e);
        }
        return res;
    }
}
