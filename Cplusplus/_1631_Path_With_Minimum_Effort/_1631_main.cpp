// Created by WXX on 2021/1/29 10:08
#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

/**
 * 执行用时：272 ms, 在所有 C++ 提交中击败了93.80%的用户
 * 内存消耗：48.6 MB, 在所有 C++ 提交中击败了24.14%的用户
 */
class Solution {
public:
    typedef pair<int, int> PII;  // (距离，点的编号)
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    int minimumEffortPath(vector<vector<int>> &heights) {

        int n = heights.size(), m = heights[0].size();
        // 建图
        vector<vector<PII>> g(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    int a = i + dx[k], b = j + dy[k];
                    if (a >= 0 && a < n && b >= 0 && b < m) {
                        int w = abs(heights[i][j] - heights[a][b]);
                        g[i * m + j].push_back({a * m + b, w});
                    }
                }
            }
        }

        // dijkstra算法
        int dist[n * m];
        memset(dist, 0x3f, sizeof dist);
        bool st[n * m];
        memset(st, false, sizeof st);
        dist[0] = 0;
        priority_queue<PII, vector<PII>, greater<PII>> q;
        q.push({0, 0});
        while (q.size()) {
            // 寻找当前距离最小的点
            auto t = q.top();
            q.pop();
            // 得到一个解
            int u = t.second, distance = t.first;
            if (st[u]) continue;
            st[u] = true;
            // 用当前得到的解更新其他点的距离
//            for (auto a : g[u]) {  // 求解最短路径的长度
//                int v = a.first, w = a.second;  // (u, v, w)
//                if (dist[u] + w < dist[v]) {
//                    dist[v] = dist[u] + w;
//                    q.push({dist[v], v});
//                }
//            }
            for (auto a : g[u]) {
                int v = a.first, w = a.second;  // (u, v, w)
                if (max(dist[u], w) < dist[v]) {
                    dist[v] = max(dist[u], w);
                    q.push({dist[v], v});
                }
            }
        }

        return dist[n * m - 1];
    }
};

int main() {

//    vector<vector<int>> heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
    vector<vector<int>> heights = {{4,  3, 4,  10, 5,  5, 9, 2},
                                   {10, 8, 2,  10, 9,  7, 5, 6},
                                   {5,  8, 10, 10, 10, 7, 4, 2},
                                   {5,  1, 3,  1,  1,  3, 1, 9},
                                   {6,  4, 10, 6,  10, 9, 4, 6}};
    cout << Solution().minimumEffortPath(heights) << endl;

    return 0;
}
