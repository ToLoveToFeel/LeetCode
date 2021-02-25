// Created by WXX on 2021/2/25 10:18
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了69.12%的用户
 * 内存消耗：10.4 MB, 在所有 C++ 提交中击败了8.28%的用户
 */
class Solution {
public:
    vector<vector<int>> transpose(vector<vector<int>> &matrix) {

        int n = matrix.size(), m = matrix[0].size();
        vector<vector<int>> res(m, vector<int>(n));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                res[j][i] = matrix[i][j];
        return res;
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
            {1, 2, 3},
            {4, 5, 6},
    };
    OutputBasicArray2D(Solution().transpose(matrix));

    return 0;
}
