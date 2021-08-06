// Created by WXX on 2021/8/6 10:04
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

typedef pair<int, int> PII;

#define x first
#define y second

class Solution {
public:
    int shortestPathLength(vector<vector<int>> &graph) {
        int n = graph.size(), INF = 1e8;
        vector<vector<int>> f(1 << n, vector<int>(n, INF));

        queue<PII> q;
        for (int i = 0; i < n; i++) {
            f[1 << i][i] = 0;
            q.push({1 << i, i});
        }

        while (q.size()) {
            auto t = q.front();
            q.pop();

            for (int z : graph[t.y]) {
                int s = t.x | 1 << z;
                if (f[s][z] > f[t.x][t.y] + 1) {
                    f[s][z] = f[t.x][t.y] + 1;
                    q.push({s, z});
                }
            }
        }

        int res = INF;
        for (int i = 0; i < n; i++)
            res = min(res, f[(1 << n) - 1][i]);
        return res;
    }
};

int main() {

    vector<vector<int>> graph = {
            {1, 2, 3},
            {0},
            {0},
            {0},
    };
    cout << Solution().shortestPathLength(graph) << endl;  // 4

    return 0;
}
