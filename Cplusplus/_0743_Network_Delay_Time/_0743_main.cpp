// Created by WXX on 2021/8/2 9:32
#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

/**
 * 执行用时：148 ms, 在所有 C++ 提交中击败了45.24%的用户
 * 内存消耗：39.3 MB, 在所有 C++ 提交中击败了34.29%的用户
 */
const int N = 110, INF = 0x3f3f3f3f;

int g[N][N];
int dist[N];
bool st[N];

class Solution {
public:
    int networkDelayTime(vector<vector<int>> &times, int n, int k) {

        memset(g, 0x3f, sizeof g);
        for (auto e : times) g[e[0]][e[1]] = e[2];
        return dijkstra(k, n);
    }

    int dijkstra(int start, int n) {

        memset(dist, 0x3f, sizeof dist);
        memset(st, 0, sizeof st);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++)
                if (!st[j] && (t == -1 || dist[j] < dist[t]))
                    t = j;

            st[t] = true;

            for (int j = 1; j <= n; j++)
                dist[j] = min(dist[j], dist[t] + g[t][j]);
        }

        int res = 0;
        for (int i = 1; i <= n; i++) res = max(res, dist[i]);

        if (res == INF) res = -1;
        return res;
    }
};

int main() {

    vector<vector<int>> times = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
    };
    cout << Solution().networkDelayTime(times, 4, 2) << endl;  // 2

    return 0;
}
