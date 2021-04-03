// Created by WXX on 2021/4/3 20:41
#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：8.2 MB, 在所有 C++ 提交中击败了80.81%的用户
 */
class Solution {
public:
    typedef pair<int, int> PII;

    int n, m;
    vector<vector<int>> g;
    PII match[10][10];
    bool st[10][10];
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    bool find(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a < 0 || a >= n || b < 0 || b >= m) continue;
            if (st[a][b] || g[a][b]) continue;

            st[a][b] = true;
            PII t = match[a][b];
            if (t.first == -1 || find(t.first, t.second)) {
                match[a][b] = {x, y};
                return true;
            }
        }
        return false;
    }

    int domino(int _n, int _m, vector<vector<int>> &broken) {

        n = _n, m = _m;
        g = vector<vector<int>>(n, vector<int>(m, 0));
        for (int i = 0; i < broken.size(); i++) {
            int a = broken[i][0], b = broken[i][1];
            g[a][b] = 1;
        }

        memset(match, -1, sizeof match);

        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if ((i + j) % 2 && !g[i][j]) {
                    memset(st, 0, sizeof st);
                    if (find(i, j)) res++;
                }
        return res;
    }
};

int main() {

    vector<vector<int>> broken = {{1, 0}, {1, 1}};
    cout << Solution().domino(2, 3, broken) << endl;  // 2

    return 0;
}
