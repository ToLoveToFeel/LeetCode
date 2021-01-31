// Created by WXX on 2021/1/27 15:28
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了98.80%的用户
 * 内存消耗：13 MB, 在所有 C++ 提交中击败了96.10%的用户
 */
class Solution {
public:
    vector<int> findOrder(int n, vector<vector<int>> &edges) {

        vector<vector<int>> g(n);
        vector<int> d(n);  // 入度
        for (auto &e : edges) {
            auto b = e[0], a = e[1];
            g[a].push_back(b);
            d[b]++;
        }

        queue<int> q;
        for (int i = 0; i < n; i++)
            if (d[i] == 0)
                q.push(i);

        vector<int> res;
        while (q.size()) {
            auto a = q.front();
            q.pop();
            res.push_back(a);
            for (auto b : g[a])
                if (--d[b] == 0)
                    q.push(b);
        }
        if (res.size() < n) res = {};
        return res;
    }
};

void OutputBasicArray1D(vector<int> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    int n = 4;
    vector<vector<int>> edges = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    vector<int> res = Solution().findOrder(n, edges);
    OutputBasicArray1D(res);

    return 0;
}
