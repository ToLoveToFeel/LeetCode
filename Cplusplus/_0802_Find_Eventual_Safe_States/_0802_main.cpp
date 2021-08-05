// Created by ToLoveToFeel on 2021/8/5 10:50
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * 执行用时：184 ms, 在所有 C++ 提交中击败了63.76%的用户
 * 内存消耗：60 MB, 在所有 C++ 提交中击败了44.00%的用户
 */
class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>> &graph) {
        int n = graph.size();
        vector<int> d(n);
        vector<vector<int>> g(n);  // 存储反向图
        for (int i = 0; i < n; i++)
            for (auto b : graph[i]) {
                int a = i;
                g[b].push_back(a);
                d[a]++;  // a的入度增加一
            }

        queue<int> q;
        for (int i = 0; i < n; i++)
            if (d[i] == 0)
                q.push(i);
        while (q.size()) {
            auto t = q.front();
            q.pop();
            for (auto i : g[t])
                if (--d[i] == 0)
                    q.push(i);
        }

        vector<int> res;
        for (int i = 0; i < n; i++)
            if (d[i] == 0)
                res.push_back(i);
        return res;
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

    vector<vector<int>> graph = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {},
    };
    OutputBasicArray1D(Solution().eventualSafeNodes(graph));  // [2, 4, 5, 6]

    return 0;
}
