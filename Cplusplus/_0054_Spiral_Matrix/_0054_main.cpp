// Created by WXX on 2021/3/15 9:22
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了32.46%的用户
 * 内存消耗：6.6 MB, 在所有 C++ 提交中击败了84.80%的用户
 */
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>> &matrix) {
        vector<int> res;
        int n = matrix.size();
        if (!n) return res;
        int m = matrix[0].size();

        int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};  // 右，下，左，上
        vector<vector<bool>> st(n, vector<bool>(m));

        for (int i = 0, x = 0, y = 0, d = 0; i < n * m; i++) {
            res.push_back(matrix[x][y]);
            st[x][y] = true;

            int a = x + dx[d], b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= m || st[a][b]) {
                d = (d + 1) % 4;
                a = x + dx[d], b = y + dy[d];
            }
            x = a, y = b;
        }
        return res;
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

//    vector<vector<int>> matrix = {
//            {1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9}
//    };
    vector<vector<int>> matrix = {
            {3},
            {2}
    };
    OutputBasicArray1D(Solution().spiralOrder(matrix));

    return 0;
}
