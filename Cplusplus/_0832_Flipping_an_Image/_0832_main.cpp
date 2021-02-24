// Created by WXX on 2021/2/24 9:48
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了55.16%的用户
 * 内存消耗：8.3 MB, 在所有 C++ 提交中击败了68.03%的用户
 */
class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>> &A) {

        int n = A.size();
        vector<vector<int>> res(n, vector<int>(n));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res[i][j] = 1 - A[i][n - 1 - j];
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

    vector<vector<int>> A = {
            {1, 1, 0},
            {1, 0, 1},
            {0, 0, 0}
    };
    OutputBasicArray2D(Solution().flipAndInvertImage(A));

    return 0;
}
