// Created by WXX on 2021/4/13 9:11
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了40.35%的用户
 * 内存消耗：14.2 MB, 在所有 C++ 提交中击败了5.03%的用户
 */
class Solution {
public:
    vector<int> color;
    vector<vector<int>> g;

    bool isBipartite(vector<vector<int>> &graph) {

        g = graph;
        int n = g.size();
        color.resize(n, 0);
        for (int i = 0; i < n; i++)
            if (!color[i])
                if (!dfs(i, 1))
                    return false;
        return true;
    }

    bool dfs(int u, int c) {
        color[u] = c;
        for (auto w : g[u]) {
            if (!color[w]) {
                if (!dfs(w, 3 - c)) return false;
            } else if (color[w] == c) return false;
        }
        return true;
    }
};

int main() {

    vector<vector<int>> graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
    cout << Solution().isBipartite(graph) << endl;  // false

    return 0;
}
