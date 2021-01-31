// Created by WXX on 2021/1/31 21:51
#include <iostream>
#include <vector>

using namespace std;

// https://www.acwing.com/video/1689/  64:00
class Solution {
public:

    vector<vector<int>> g;
    // d1[u]存储以u为根的子树的高度最大值, d2[u]存储以u为根的子树的次大值（最大值可能等于次大值）
    // p1[u]存储最大值路径，如p1[u]=x，说明最大值路径经过(u, x)。
    // p2存储次大值路径，在这个题目中没有用，删掉也行，写出来完全是为了对称
    // up[u] : 从u向上走的最大长度
    vector<int> d1, d2, p1, p2, up;

    vector<int> findMinHeightTrees(int n, vector<vector<int>> &edges) {

        g.resize(n);
        d1 = d2 = p1 = p2 = up = vector<int>(n);
        for (auto &e : edges) {
            int a = e[0], b = e[1];
            g[a].push_back(b), g[b].push_back(a);
        }

        // 这两句话不能颠倒，因为计算up需要用到down，计算down不需要用到up
        dfs1(0, -1);  // 更新down
        dfs2(0, -1);  // 更新up

        int mind = n + 1;
        for (int i = 0; i < n; i++) mind = min(mind, max(up[i], d1[i]));
        vector<int> res;
        for (int i = 0; i < n; i++)
            if (max(up[i], d1[i]) == mind)
                res.push_back(i);
        return res;
    }

    void dfs1(int u, int father) {
        for (int x : g[u]) {
            if (x == father) continue;
            dfs1(x, u);  // 算出孩子之后，才能计算当前节点
            int d = d1[x] + 1;
            if (d >= d1[u]) {
                d2[u] = d1[u], d1[u] = d;  // 次大值=最大值，最大值=新的最大值
                p2[u] = p1[u], p1[u] = x;
            } else if (d > d2[u]) {
                d2[u] = d;
                p2[u] = x;
            }
        }
    }

    void dfs2(int u, int father) {
        for (int x : g[u]) {
            if (x == father) continue;
            if (p1[u] == x) up[x] = max(up[u], d2[u]) + 1;
            else up[x] = max(up[u], d1[u]) + 1;
            dfs2(x, u);  // 计算父节点之后，才能计算子节点
        }
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    int n = 6;
    vector<vector<int>> edges = {{3, 0},
                                 {3, 1},
                                 {3, 2},
                                 {3, 4},
                                 {5, 4}};
    OutputBasicArray1D(Solution().findMinHeightTrees(n, edges));

    return 0;
}
