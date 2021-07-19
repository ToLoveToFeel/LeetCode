// Created by WXX on 2021/7/19 11:19
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};  // 右，下，左，上

    vector<int> spiralOrder(vector<vector<int>> &matrix) {

        if (matrix.empty() || matrix[0].empty()) return {};
        vector<int> res;
        int n = matrix.size(), m = matrix[0].size();
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

    vector<vector<int>> matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
    };
    OutputBasicArray1D(Solution().spiralOrder(matrix));

    return 0;
}
