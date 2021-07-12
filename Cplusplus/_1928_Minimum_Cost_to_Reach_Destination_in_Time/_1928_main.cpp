// Created by WXX on 2021/7/12 13:43
#include <iostream>
#include <vector>
#include <cstring>
#include <queue>

using namespace std;

#define x first
#define y second

typedef pair<int, int> PII;

const int N = 1010, M = 2010, INF = 0x3f3f3f3f;

int h[N], e[M], w[M], ne[M], idx;
int dist[N][N];
bool st[N][N];  // spfa中判断是否在队列中的数组

class Solution {
public:
    void add(int a, int b, int c) {
        e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
    }

    int minCost(int m, vector<vector<int>> &edges, vector<int> &pf) {

        int n = pf.size();

        memset(h, -1, sizeof h), idx = 0;
        for (auto &e : edges) {
            int a = e[0], b = e[1], c = e[2];
            add(a, b, c), add(b, a, c);
        }

        memset(dist, 0x3f, sizeof dist);
        dist[0][0] = pf[0];
        queue<PII> q;
        q.push({0, 0});  // (顶点, 用时)

        while (q.size()) {
            auto t = q.front();
            q.pop();
            st[t.x][t.y] = false;

            for (int i = h[t.x]; ~i; i = ne[i]) {
                int x = e[i];  // 点
                int y = t.y + w[i];
                if (y > m) continue;  // 时间超过m，没必要更新
                if (dist[x][y] > dist[t.x][t.y] + pf[x]) {
                    dist[x][y] = dist[t.x][t.y] + pf[x];
                    if (!st[x][y]) {
                        q.push({x, y});
                        st[x][y] = true;
                    }
                }
            }
        }

        int res = INF;
        for (int i = 0; i <= m; i++) res = min(res, dist[n - 1][i]);
        if (res == INF) res = -1;
        return res;
    }
};

int main() {

    vector<vector<int>> edges = {{0, 1, 10},
                                 {1, 2, 10},
                                 {2, 5, 10},
                                 {0, 3, 1},
                                 {3, 4, 10},
                                 {4, 5, 15}};
    vector<int> passingFees = {5, 1, 2, 20, 20, 3};
    cout << Solution().minCost(30, edges, passingFees) << endl;  // 11

    return 0;
}
