// Created by WXX on 2021/3/21 10:18
#include <iostream>
#include <vector>

using namespace std;

// 思路：用r0记录第一行是否有0，用c0记录第一列是否有0
//      用第一行记录对应的每一列是否存在0，用第一列记录每一列是否存在0
/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了80.35%的用户
 * 内存消耗：12.9 MB, 在所有 C++ 提交中击败了65.09%的用户
 */
class Solution {
public:
    void setZeroes(vector<vector<int>> &matrix) {

        if (matrix.empty() || matrix[0].empty()) return;
        int n = matrix.size(), m = matrix[0].size();

        int r0 = 1, c0 = 1;
        for (int i = 0; i < m; i++) if (!matrix[0][i]) r0 = 0;
        for (int i = 0; i < n; i++) if (!matrix[i][0]) c0 = 0;

        for (int i = 1; i < n; i++)  // 第i行是否存在0
            for (int j = 0; j < m; j++)
                if (!matrix[i][j])
                    matrix[i][0] = 0;
        for (int i = 1; i < m; i++)  // 第i列是否存在0
            for (int j = 0; j < n; j++)
                if (!matrix[j][i])
                    matrix[0][i] = 0;

        for (int i = 1; i < n; i++)
            if (!matrix[i][0])
                for (int j = 0; j < m; j++)
                    matrix[i][j] = 0;
        for (int i = 1; i < m; i++)
            if (!matrix[0][i])
                for (int j = 0; j < n; j++)
                    matrix[j][i] = 0;

        if (!r0) for (int i = 0; i < m; i++) matrix[0][i] = 0;
        if (!c0) for (int i = 0; i < n; i++) matrix[i][0] = 0;
    }
};

void OutputBasicArray2D(vector<vector<int>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (i > 0 && i < nums.size()) cout << ' ';
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", " << endl;
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<int>> matrix = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
    };
    Solution().setZeroes(matrix);
    OutputBasicArray2D(matrix);

    return 0;
}
