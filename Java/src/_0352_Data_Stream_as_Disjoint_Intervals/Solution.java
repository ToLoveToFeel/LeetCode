package _0352_Data_Stream_as_Disjoint_Intervals;

import _0000_study._common.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Date: 2021/5/11 21:18
 */
public class Solution {

    static class SummaryRanges {

        static final int INF = (int) 1e9;

        static class MyPair implements Comparable<MyPair> {
            int x, y;
            public MyPair(int x, int y) {
                this.x = x; this.y = y;
            }
            @Override
            public int compareTo(MyPair o) {
                if (x == o.x) return y - o.y;
                return x - o.x;
            }
        }

        TreeSet<MyPair> S = new TreeSet<>();

        /** Initialize your data structure here. */
        public SummaryRanges() {
            S.add(new MyPair(-INF, -INF)); S.add(new MyPair(INF, INF));
        }

        public void addNum(int x) {
            MyPair l = S.floor(new MyPair(x, Integer.MAX_VALUE));  // 返回小于等于t的最大元素
            MyPair r = S.higher(new MyPair(x, Integer.MAX_VALUE));  // 返回大于t的最小元素

            if (l.y >= x) return;
            if (l.y == x - 1 && r.x == x + 1) {
                S.add(new MyPair(l.x, r.y));
                S.remove(l); S.remove(r);
            } else if (l.y == x - 1) {
                S.add(new MyPair(l.x, x));
                S.remove(l);
            } else if (r.x == x + 1) {
                S.add(new MyPair(x, r.y));
                S.remove(r);
            } else {
                S.add(new MyPair(x, x));
            }
        }

        public int[][] getIntervals() {

            int n = S.size();
            List<int[]> res = new ArrayList<>();
            for (MyPair p : S)
                if (p.x != -INF && p.x != INF)
                    res.add(new int[]{p.x, p.y});
            return res.toArray(new int[0][0]);
        }
    }

    public static void main(String[] args) {

        SummaryRanges t = new SummaryRanges();
        t.addNum(1);
        t.addNum(3);
        t.addNum(7);
        t.addNum(2);
        t.addNum(6);
        Output.OutputBasicArray2D1(t.getIntervals());  // [[1, 3], [6, 7]]
    }
}
