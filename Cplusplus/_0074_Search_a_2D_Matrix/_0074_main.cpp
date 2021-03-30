// Created by WXX on 2021/3/30 8:57
#include <iostream>
#include <vector>

using namespace std;

// 考点：二分、一二维坐标转换
/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了87.61%的用户
 * 内存消耗：9.1 MB, 在所有 C++ 提交中击败了94.23%的用户
 */
class Solution {
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target) {

        int n = matrix.size(), m = matrix[0].size();
        if (matrix[0][0] > target || matrix[n - 1][m - 1] < target) return false;

        int l = 0, r = n * m - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (matrix[mid / m][mid % m] >= target) r = mid;
            else l = mid + 1;
        }
        return matrix[l / m][l % m] == target;
    }
};

int main() {

    vector<vector<int>> matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
    };
    cout << Solution().searchMatrix(matrix, 3) << endl;  // true
    cout << Solution().searchMatrix(matrix, 13) << endl;  // false

    return 0;
}
