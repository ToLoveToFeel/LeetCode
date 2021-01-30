// Created by WXX on 2021/1/30 11:07
#include <iostream>
#include <vector>
#include <cstring>
#include <queue>

using namespace std;

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了95.92%的用户
 * 内存消耗：8 MB, 在所有 C++ 提交中击败了98.83%的用户
 */
class Solution {
public:
    typedef pair<int, pair<int, int>> PII;  // (距离，(x, y))
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    int swimInWater(vector<vector<int>> &grid) {

        int n = grid.size();

        // dijkstra算法
        int dist[n * n];
        memset(dist, 0x3f, sizeof dist);
        bool st[n * n];
        memset(st, false, sizeof st);
        priority_queue<PII, vector<PII>, greater<PII>> q;
        dist[0] = grid[0][0];  // grid[a * n + b] : 从(0, 0)到达(a, b)必须要等待的最少时间（a*b != 0）
        q.push({dist[0], {0, 0}});
        while (q.size()) {
            // 寻找当前距离最小的点
            auto t = q.top();
            q.pop();
            // 得到一个解
            auto u = t.second;
            int x = u.first, y = u.second, p = x * n + y;
            if (st[p]) continue;
            st[p] = true;
            // 用当前得到的解更新其他点的距离
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < n && max(dist[p], grid[a][b]) < dist[a * n + b]) {
                    dist[a * n + b] = max(dist[p], grid[a][b]);
                    q.push({dist[a * n + b], {a, b}});
                }
            }
        }

        return dist[n * n - 1];
    }
};

int main() {

//    vector<vector<int>> grid = {
//            {0,  1,  2,  3,  4},
//            {24, 23, 22, 21, 5},
//            {12, 13, 14, 15, 16},
//            {11, 17, 18, 19, 20},
//            {10, 9,  8,  7,  6}
//    };  // 16
    vector<vector<int>> grid = {
            {3, 2},
            {0, 1}
    };  // 3
    cout << Solution().swimInWater(grid) << endl;

    return 0;
}
