// Created by ToLoveToFeel on 2021/8/9 10:12
#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

// TLE: 39个点通过37个
class Solution {
public:
    typedef pair<int, int> PII;

    int n, m;
    vector<vector<int>> g;
    vector<vector<int>> f;
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    vector<vector<int>> matrixRankTransform(vector<vector<int>> &matrix) {

        g = matrix;
        n = g.size(), m = g[0].size();
        f = vector<vector<int>>(n, vector<int>(m));

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dfs(i, j);

        return f;
    }

    struct pair_hash {
        inline size_t operator()(const pair<int, int> &p) const {
            return p.first * 1000 + p.second;
        }
    };

    // 找到所有关联的值等于g[x][y]的坐标
    void find(unordered_set<PII, pair_hash> &S, int x, int y) {

        for (int i = 0; i < m; i++)
            if (g[x][i] == g[x][y] && S.count({x, i}) == 0) {
                S.insert({x, i});
                find(S, x, i);
            }
        for (int i = 0; i < n; i++)
            if (g[i][y] == g[x][y] && S.count({i, y}) == 0) {
                S.insert({i, y});
                find(S, i, y);
            }
    }

    int dfs(int x, int y) {
        if (f[x][y]) return f[x][y];

        bool lt = true;  // g[x][y]是否小于所在行和所在列的数
        unordered_set<PII, pair_hash> S;  // 记录值等于(x, y)的纵坐标
        find(S, x, y);

        // 计算所有坐标为(x, y)点的秩，取排名最大的那个
        int rank = 1;
        for (auto p : S) {
            int a = p.first, b = p.second;
            // 考虑第x行
            for (int i = 0; i < m; i++)
                if (i != b) {  // (a, i)
                    if (g[a][i] < g[a][b]) {
                        lt = false;
                        rank = max(rank, dfs(a, i) + 1);
                    }
                }
            // 考虑第y列
            for (int i = 0; i < n; i++)
                if (i != a) {  // (i, b)
                    if (g[i][b] < g[a][b]) {
                        lt = false;
                        rank = max(rank, dfs(i, b) + 1);
                    }
                }
        }
        for (auto p : S) {
            int a = p.first, b = p.second;
            f[a][b] = rank;
        }

        if (lt) f[x][y] = rank;
        return f[x][y];
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

//    vector<vector<int>> matrix = {
//            {-37, -50, -3,  44},
//            {-37, 46,  13,  -32},
//            {47,  -42, -3,  -40},
//            {-17, -22, -39, 24}
//    };
    vector<vector<int>> matrix = {
            {-24, -9,  -14, -15, 44,  31,  -46, 5,   20,  -5,  34},
            {9,   -40, -49, -50, 17,  40,  35,  30,  -39, 36,  -49},
            {-18, -43, -40, -5,  -30, 9,   -28, -41, -6,  -47, 12},
            {11,  42,  -23, 20,  35,  34,  -39, -16, 27,  34,  -15},
            {32,  27,  -30, 29,  -48, 15,  -50, -47, -28, -21, 38},
            {45,  48,  -1,  -18, 9,   -4,  -13, 10,  9,   8,   -41},
            {-42, -35, 20,  -17, 10,  5,   36,  47,  6,   1,   8},
            {3,   -50, -23, 16,  31,  2,   -39, 36,  -25, -30, 37},
            {-48, -41, 18,  -31, -48, -1,  -42, -3,  -8,  -29, -2},
            {17,  0,   31,  -30, -43, -20, -37, -6,  -43, 8,   19},
            {42,  25,  32,  27,  -2,  45,  12,  -9,  34,  17,  32}
    };
    OutputBasicArray2D(Solution().matrixRankTransform(matrix));

    return 0;
}
