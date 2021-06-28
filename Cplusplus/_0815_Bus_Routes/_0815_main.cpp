// Created by WXX on 2021/6/28 9:54
#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

/**
 * 执行用时：228 ms, 在所有 C++ 提交中击败了68.60%的用户
 * 内存消耗：51.3 MB, 在所有 C++ 提交中击败了53.16%的用户
 */
class Solution {
public:
    int numBusesToDestination(vector<vector<int>> &routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.size();
        unordered_map<int, vector<int>> g;  // 倒排索引：(车站，经过该车站的公交路线)
        vector<int> dist(n, 1e8);  // 从source到公交路线需要做的公交车数量
        queue<int> q;  // 存储公交路线
        for (int i = 0; i < n; i++) {
            for (int x : routes[i]) {
                if (x == source) {
                    dist[i] = 1;
                    q.push(i);
                }
                g[x].push_back(i);
            }
        }

        while (q.size()) {
            int t = q.front();
            q.pop();

            for (int x : routes[t]) {
                if (target == x) return dist[t];
                for (auto y : g[x]) {
                    if (dist[y] > dist[t] + 1) {
                        dist[y] = dist[t] + 1;
                        q.push(y);
                    }
                }
                g.erase(x);
            }
        }
        return -1;
    }
};

int main() {

    vector<vector<int>> routes = {{1, 2, 7}, {3, 6, 7}};
    cout << Solution().numBusesToDestination(routes, 1, 6) << endl;  // 2

    return 0;
}
