// Created by WXX on 2021/5/16 13:12
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：220 ms, 在所有 C++ 提交中击败了13.65%的用户
 * 内存消耗：60.6 MB, 在所有 C++ 提交中击败了6.36%的用户
 */
class Solution {
public:
    vector<vector<int>> s;  // 两维，第一维是idx，第二维决定对应位是0还是1

    void insert(int x) {
        int p = 0;
        for (int i = 30; ~i; i--) {
            int u = x >> i & 1;
            if (!s[p][u]) s[p][u] = s.size(), s.push_back({0, 0});
            p = s[p][u];
        }
    }

    int query(int x) {
        int p = 0, res = 0;
        for (int i = 30; i >= 0; i--) {
            int u = x >> i & 1;
            if (s[p][!u]) p = s[p][!u], res = res * 2 + !u;
            else p = s[p][u], res = res * 2 + u;
        }
        return res ^ x;
    }

    int findMaximumXOR(vector<int> &nums) {
        s.push_back({0, 0});  // 创建根节点（空节点）
        int res = 0;
        for (auto x : nums) {
            res = max(res, query(x));
            insert(x);
        }
        return res;
    }
};

int main() {

    vector<int> nums = {3, 10, 5, 25, 2, 8};
    cout << Solution().findMaximumXOR(nums) << endl;  // 28

    return 0;
}
