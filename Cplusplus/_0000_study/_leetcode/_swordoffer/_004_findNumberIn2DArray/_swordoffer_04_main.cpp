// Created by WXX on 2021/7/18 11:29
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool findNumberIn2DArray(vector<vector<int>> &matrix, int target) {
        if (matrix.empty() || matrix[0].empty()) return false;

        int n = matrix.size(), m = matrix[0].size();
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            int t = matrix[i][j];
            if (t == target) return true;
            else if (t > target) j--;
            else i++;
        }
        return false;
    }
};

int main() {

    vector<vector<int>> matrix = {
            {1,  4,  7,  11, 15},
            {2,  5,  8,  12, 19},
            {3,  6,  9,  16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
    };
    cout << Solution().findNumberIn2DArray(matrix, 5) << endl;  // true
    cout << Solution().findNumberIn2DArray(matrix, 20) << endl;  // false

    return 0;
}
