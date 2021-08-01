// Created by WXX on 2021/8/1 10:03
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：10.2 MB, 在所有 C++ 提交中击败了57.55%的用户
 */
class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>> &mat, int k) {
        vector<pair<int, int>> row;  // (每行军人数, 行号)
        int n = mat.size(), m = mat[0].size();
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < m; j++) s += mat[i][j];
            row.push_back({s, i});
        }
        sort(row.begin(), row.end());

        vector<int> res;
        for (int i = 0; i < k; i++) res.push_back(row[i].second);
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

    vector<vector<int>> mat = {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
    };
    OutputBasicArray1D(Solution().kWeakestRows(mat, 3));  // [2, 0, 3]

    return 0;
}
