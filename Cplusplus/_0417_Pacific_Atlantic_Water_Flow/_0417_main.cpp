// Created by WXX on 2021/5/31 20:59
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：44 ms, 在所有 C++ 提交中击败了74.34%的用户
 * 内存消耗：18.6 MB, 在所有 C++ 提交中击败了27.34%的用户
 */
class Solution {
public:

    int n, m;
    vector<vector<int>> w;
    vector<vector<int>> st;

    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    void dfs(int x, int y, int t) {
        if (st[x][y] & t) return;
        st[x][y] |= t;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && w[a][b] >= w[x][y])
                dfs(a, b, t);
        }
    }

    vector<vector<int>> pacificAtlantic(vector<vector<int>> &heights) {
        w = heights;
        if (w.empty() || w[0].empty()) return {};
        n = w.size(), m = w[0].size();
        st = vector<vector<int>>(n, vector<int>(m));

        for (int i = 0; i < m; i++) dfs(0, i, 1);  // 遍历第一行
        for (int i = 0; i < n; i++) dfs(i, 0, 1);  // 遍历第一列
        for (int i = 0; i < m; i++) dfs(n - 1, i, 2);  // 遍历最后一行
        for (int i = 0; i < n; i++) dfs(i, m - 1, 2);  // 遍历最后一列

        vector<vector<int>> res;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (st[i][j] == 3)
                    res.push_back({i, j});
        return res;
    }
};

void OutputBasicArray2D1(vector<vector<int>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<int>> heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 5},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4},
    };
    OutputBasicArray2D1(Solution().pacificAtlantic(heights));

    return 0;
}
