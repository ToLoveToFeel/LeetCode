// Created by WXX on 2021/3/2 16:53
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

// 思路：将树从小到大排序。然后求两点之间的最短路径，有多少棵树求多少次bfs
class Solution {
public:
    struct Tree {
        int x, y, h;  // 位于(x, y)的树的高度为h
        bool operator<(const Tree &t) const {
            return h < t.h;
        }
    };

    int n, m;
    vector<vector<int>> g;

    int bfs(Tree st, Tree ed) {
        if (st.x == ed.x && st.y == ed.y) return 0;  // 起点终点都是出发点
        queue<Tree> q;
        const int INF = 1e8;
        vector<vector<int>> dist(n, vector<int>(m, INF));
        dist[st.x][st.y] = 0;
        q.push(st);
        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
        while (q.size()) {
            auto t = q.front();
            q.pop();
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && g[x][y]) {
                    if (dist[x][y] > dist[t.x][t.y] + 1) {  // 没有判重数组，必须有这句话
                        dist[x][y] = dist[t.x][t.y] + 1;
                        if (x == ed.x && y == ed.y) return dist[x][y];
                        q.push({x, y});
                    }
                }
            }
        }
        return -1;
    }

    int cutOffTree(vector<vector<int>> &forest) {
        g = forest;
        n = g.size(), m = g[0].size();
        vector<Tree> trs;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (g[i][j] > 1)
                    trs.push_back({i, j, g[i][j]});
        sort(trs.begin(), trs.end());
        Tree last = {0, 0};
        int res = 0;
        for (auto &tr : trs) {
            int t = bfs(last, tr);  // last -> tr
            if (t == -1) return -1;
            res += t;
            last = tr;  // 更新last
        }
        return res;
    }
};

int main() {

    vector<vector<int>> forest = {{1, 2, 3},
                                  {0, 0, 0},
                                  {7, 6, 5}};
    cout << Solution().cutOffTree(forest) << endl;  // -1

    return 0;
}
