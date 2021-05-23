// Created by WXX on 2021/5/23 10:44
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：816 ms, 在所有 C++ 提交中击败了84.97%的用户
 * 内存消耗：262.3 MB, 在所有 C++ 提交中击败了29.15%的用户
 */
class Solution {
public:
    struct Node {
        Node *son[2];
        int min;  // 以该节点为根的子树存储的最小值
        Node() {
            son[0] = son[1] = NULL;
            min = INT_MAX;
        }
    } *root;

    void insert(int val) {
        auto p = root;
        p->min = min(p->min, val);
        for (int i = 29; i >= 0; i--) {
            int u = val >> i & 1;
            if (!p->son[u]) p->son[u] = new Node();
            p = p->son[u];
            p->min = min(p->min, val);
        }
    }

    // 返回数值不大于m的与x异或值最大的结果
    int query(int x, int m) {
        auto p = root;
        if (p->min > m) return -1;
        int res = 0;
        for (int i = 29; i >= 0; i--) {
            int u = x >> i & 1;
            if (p->son[!u] && p->son[!u]->min <= m) p = p->son[!u], res = res * 2 + !u;
            else p = p->son[u], res = res * 2 + u;
        }
        return res ^ x;
    }

    vector<int> maximizeXor(vector<int> &nums, vector<vector<int>> &queries) {

        root = new Node();
        for (int x : nums) insert(x);
        vector<int> res;
        for (int i = 0; i < queries.size(); i++) {
            int x = queries[i][0], m = queries[i][1];
            res.push_back(query(x, m));
        }
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

    vector<int> nums = {0, 1, 2, 3, 4};
    vector<vector<int>> queries = {
            {3, 1},
            {1, 3},
            {5, 6},
    };
    OutputBasicArray1D(Solution().maximizeXor(nums, queries));

    return 0;
}
