#include <iostream>
#include <vector>

using namespace std;

const int N = 40010;

int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

int p[N], sz[N];

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

void merge(int x, int y) {
    int p1 = find(x), p2 = find(y);
    if (p1 != p2) {
        p[p1] = p2;
        sz[p2] += sz[p1];
    }
}

/**
 * 执行用时：548 ms, 在所有 C++ 提交中击败了67.39%的用户
 * 内存消耗：114.7 MB, 在所有 C++ 提交中击败了40.21%的用户
 */
class Solution {
public:
    vector<int> hitBricks(vector<vector<int>> &grid, vector<vector<int>> &hits) {

        int m = grid.size(), n = grid[0].size();  // 行数、列数
        // 根据hits内容先将砖块打掉
        vector<vector<int>> g = grid;
        for (auto hit : hits) g[hit[0]][hit[1]] = 0;

        for (int i = 0; i <= m * n; i++) p[i] = i, sz[i] = 1;
        // 根据打掉砖块后的墙面g初始化并查集
        int ceiling = m * n;  // 代表天花板，所有挨着天花板的砖块都会合并到这个集合中
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (g[i][j] == 1) {
                    // 说明(i, j)挨着天花板
                    if (i == 0) merge(ceiling, j);  // i * n + j == j
                    for (int k = 0; k < 4; k++) {  // 当前考察的砖块(i, j)的四周是否有砖块
                        int a = i + dx[k], b = j + dy[k];
                        if (a >= 0 && a < m && b >= 0 && b < n && g[a][b] == 1)
                            merge(i * n + j, a * n + b);
                    }
                }
        }

        vector<int> res(hits.size(), 0);
        // 如果你先还原先掉落的，可能出现问题，本来一些位置应该有砖块的，但是还没有还原
        // 所以要反向还原
        for (int i = hits.size() - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] == 0) continue;  // 说明在没有砖块的地方敲打了一下，不会掉落砖块

            int pre = sz[find(ceiling)];  // 和天花板挨着的砖块(集合A)或者 挨着A的砖块的数量
            if (x == 0) merge(ceiling, y);  // 当前考察的砖块(x, y)挨着天花板
            for (int j = 0; j < 4; j++) {  // 当前考察的砖块(x, y)的四周是否有砖块
                int a = x + dx[j], b = y + dy[j];
                if (a >= 0 && a < m && b >= 0 && b < n && g[a][b] == 1)
                    merge(x * n + y, a * n + b);
            }
            int size = sz[find(ceiling)];
            // 这里必须加上max，否则第三个样例无法通过
            // 即当前砖块是因为其他砖块掉落而掉落的
            res[i] = max(0, size - pre - 1);
            g[x][y] = 1;  // 加入当前考察的砖块(i, j)
        }

        return res;
    }
};

void OutputBasicArray1D(vector<int> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<int>> gird1 = {{1, 0, 0, 0}, {1, 1, 1, 0}};
    vector<vector<int>> hit1 = {{1, 0}};
    vector<int> res1 = Solution().hitBricks(gird1, hit1);
    OutputBasicArray1D(res1);

    vector<vector<int>> gird2 = {{1, 0, 0, 0}, {1, 1, 0, 0}};
    vector<vector<int>> hit2 = {{1, 1}, {1, 0}};
    vector<int> res2 = Solution().hitBricks(gird2, hit2);
    OutputBasicArray1D(res2);

    vector<vector<int>> gird3 = {{1}, {1}, {1}, {1}, {1}};
    vector<vector<int>> hit3 = {{3, 0}, {4, 0}, {1, 0}, {2, 0}, {0, 0}};
    vector<int> res3 = Solution().hitBricks(gird3, hit3);
    OutputBasicArray1D(res3);

    return 0;
}