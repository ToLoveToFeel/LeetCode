#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

/**
 * 执行用时：932 ms, 在所有 C++ 提交中击败了51.64%的用户
 * 内存消耗：151.7 MB, 在所有 C++ 提交中击败了8.19%的用户
 */
// 采用prim算法解决
class Solution {
private:  // 如下的变量不能设置为全局变量，因为在Leetcode中会出错，但是本地不出错
    const static int N = 1010;
    const static int INF = 0x3f3f3f3f;

    int n;  // 点数
    int g[N][N];  // 邻接矩阵存储稠密图
    int dist[N]; // dist[j] 表示从已经求得mst的集合中到达j点的最短的一条
    int st[N];

public:
    int minCostConnectPoints(vector<vector<int>> &points) {

        int n = points.size();

        // 建图
        memset(g, 0x3f, sizeof g);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                vector<int> p1 = points[i], p2 = points[j];
                g[i][j] = g[j][i] = abs(p1[0] - p2[0]) + abs(p1[1] - p2[1]);
            }
        }

        // prim算法
        memset(dist, 0x3f, sizeof dist);
        memset(st, 0, sizeof st);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++)
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;
//            if (i != 0 && dist[t] == INF) return INF;  // 不可能
            if (i != 0) res += dist[t];
            st[t] = true;
            for (int j = 0; j < n; j++) dist[j] = min(dist[j], g[t][j]);
        }

        return res;
    }
};

int main() {

//    vector<vector<int>> points = {{0, 0}, {2, 2}, {3, 10}, {7, 0}};
    vector<vector<int>> points = {{3, 12}, {-2, 5}, {-4, 1}};
    cout << Solution().minCostConnectPoints(points) << endl;

    return 0;
}
