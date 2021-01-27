// Created by WXX on 2021/1/27 14:53
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// 拓扑排序
/**
 * 执行用时：44 ms, 在所有 C++ 提交中击败了35.62%的用户
 * 内存消耗：12.8 MB, 在所有 C++ 提交中击败了28.56%的用户
 */
class Solution {
public:
    bool canFinish(int n, vector<vector<int>> &edges) {

        vector<vector<int>> g(n);
        vector<int> d(n);  // 存储入度
        for (auto &e : edges) {
            int b = e[0], a = e[1];
            g[a].push_back(b);
            d[b]++;
        }

        queue<int> q;
        for (int i = 0; i < n; i++)
            if (d[i] == 0)
                q.push(i);

        int cnt = 0;
        while (q.size()) {
            auto a = q.front();
            q.pop();
            cnt++;
            for (auto b : g[a])
                if (--d[b] == 0)
                    q.push(b);
        }
        return cnt == n;
    }
};

int main() {

//    int n = 2;
//    vector<vector<int>> edges = {{1, 0}};
//    cout << Solution().canFinish(n, edges) << endl;  // true

    int n = 2;
    vector<vector<int>> edges = {{1, 0},
                                 {0, 1}};
    cout << Solution().canFinish(n, edges) << endl;  // false

    return 0;
}
