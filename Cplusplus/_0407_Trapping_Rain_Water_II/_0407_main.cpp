// Created by WXX on 2021/4/5 16:47
#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

// 详细分析：https://blog.csdn.net/weixin_42638946/article/details/115067840
/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了83.48%的用户
 * 内存消耗：8.1 MB, 在所有 C++ 提交中击败了85.84%的用户
 */
class Solution {
public:
    static const int N = 120;

    int dist[N][N];  // dist[i][j]表示到达(i, j)的所有路径中边权最大值的最小值
    bool st[N][N];  // 堆优化版的dijkstra算法中判重数组, 为true代表该点已经求出答案

    struct Node {
        int x, y, d;  // d: 到达(x, y)的所有路径中边权最大值的最小值
        bool operator<(const Node &t) const {
            return d > t.d;  // 默认大顶堆，需要使用小顶堆
        }
    };

    int trapRainWater(vector<vector<int>> &h) {

        int n = h.size(), m = h[0].size();

        memset(dist, 0x3f, sizeof dist);
        int res = 0;
        priority_queue<Node> heap;

        // 将四周的点加入优先队列
        for (int i = 0; i < n; i++) {
            heap.push({i, 0, h[i][0]});
            dist[i][0] = h[i][0];
            heap.push({i, m - 1, h[i][m - 1]});
            dist[i][m - 1] = h[i][m - 1];
        }
        for (int i = 1; i < m - 1; i++) {
            heap.push({0, i, h[0][i]});
            dist[0][i] = h[0][i];
            heap.push({n - 1, i, h[n - 1][i]});
            dist[n - 1][i] = h[n - 1][i];
        }

        int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

        while (heap.size()) {

            Node t = heap.top();
            heap.pop();

            if (st[t.x][t.y]) continue;
            st[t.x][t.y] = true;

            res += t.d - h[t.x][t.y];

            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if (dist[x][y] > max(t.d, h[x][y])) {  // (t.x, t.y)到(x, y)的边权为h[x][y]
                    dist[x][y] = max(t.d, h[x][y]);
                    heap.push({x, y, dist[x][y]});
                }
            }
        }

        return res;
    }
};

int main() {

    vector<vector<int>> h = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
    };
    cout << Solution().trapRainWater(h) << endl;  // 4

    return 0;
}
