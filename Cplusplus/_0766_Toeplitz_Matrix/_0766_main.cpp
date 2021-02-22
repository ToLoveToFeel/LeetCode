// Created by WXX on 2021/2/22 8:54
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了78.49%的用户
 * 内存消耗：17.1 MB, 在所有 C++ 提交中击败了68.28%的用户
 */
class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>> &matrix) {

        for (int i = 1; i < matrix.size(); i++)
            for (int j = 1; j < matrix[0].size(); j++)
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
        return true;
    }
};

int main() {

    vector<vector<int>> matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
    cout << Solution().isToeplitzMatrix(matrix) << endl;  // 1

    return 0;
}
