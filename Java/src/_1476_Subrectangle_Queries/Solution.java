package _1476_Subrectangle_Queries;

/**
 * Date: 2020/8/30 20:48
 * Content:
 */
class SubrectangleQueries {

    int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    // 暴力解法，直接全部更新
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

    public static void main(String[] args) {
        int[][] rectangle = {
                {1, 2, 1},
                {4, 3, 4},
                {3, 2, 1},
                {1, 1, 1}
        };
        SubrectangleQueries sq = new SubrectangleQueries(rectangle);
        System.out.println(sq.getValue(0, 2));
        sq.updateSubrectangle(0, 0, 3, 2, 5);
        System.out.println(sq.getValue(0, 2));
    }
}
