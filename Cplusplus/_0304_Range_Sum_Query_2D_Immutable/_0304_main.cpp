// Created by WXX on 2021/1/31 20:19
#include <iostream>
#include <vector>

using namespace std;

class NumMatrix {
public:
    vector<vector<int>> s;

    NumMatrix(vector<vector<int>> &matrix) {

        if (matrix.empty() || matrix[0].empty()) return;

        int n = matrix.size(), m = matrix[0].size();
        s = vector<vector<int>>(n + 1, vector<int>(m + 1));
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
    }

    int sumRegion(int x1, int y1, int x2, int y2) {
        x1++, y1++, x2++, y2++;
        return s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
    }
};

int main() {

    vector<vector<int>> matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
    };
    NumMatrix t = NumMatrix(matrix);
    cout << t.sumRegion(2, 1, 4, 3) << endl;  // 8
    cout << t.sumRegion(1, 1, 2, 2) << endl;  // 11
    cout << t.sumRegion(1, 2, 2, 4) << endl;  // 12

    return 0;
}
