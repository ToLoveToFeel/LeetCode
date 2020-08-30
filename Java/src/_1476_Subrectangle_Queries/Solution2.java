package _1476_Subrectangle_Queries;

import java.util.ArrayList;

/**
 * Date: 2020/8/30 20:48
 * Content:
 */
class SubrectangleQueries2 {

    int[][] rectangle;
    ArrayList<ArrayList<Integer>> history = new ArrayList<>();

    public SubrectangleQueries2(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    // 不暴力更新，存储每次的更新信息
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        history.add(new ArrayList<Integer>() {
            {
                add(row1);
                add(col1);
                add(row2);
                add(col2);
                add(newValue);
            }
        });
    }

    public int getValue(int row, int col) {
        for (int i = history.size() - 1; i >= 0; i--)
            if (history.get(i).get(0) <= row && row <= history.get(i).get(2) &&
                    history.get(i).get(1) <= col && col <= history.get(i).get(3))
                return history.get(i).get(4);

        return rectangle[row][col];
    }

    public static void main(String[] args) {
        int[][] rectangle = {
                {1, 2, 1},
                {4, 3, 4},
                {3, 2, 1},
                {1, 1, 1}
        };
        SubrectangleQueries2 sq = new SubrectangleQueries2(rectangle);
        System.out.println(sq.getValue(0, 2));
        sq.updateSubrectangle(0, 0, 3, 2, 5);
        System.out.println(sq.getValue(0, 2));
    }
}
