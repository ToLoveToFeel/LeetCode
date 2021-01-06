#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 类似于多重背包，因为数据可以选择指定次数
 * 执行用时：16 ms, 在所有 C++ 提交中击败了47.82%的用户
 * 内存消耗：11.1 MB, 在所有 C++ 提交中击败了39.18%的用户
 */
class Solution {
public:

    vector<vector<int>> ans;
    vector<int> path;

    vector<vector<int>> combinationSum2(vector<int> &c, int target) {
        sort(c.begin(), c.end());

        dfs(c, target, 0);
        return ans;
    }

    void dfs(vector<int> &c, int target, int u) {

        if (target == 0) {
            ans.push_back(path);
            return;
        }
        if (u == c.size()) return;

        // 统计相同元素个数
        int k = u + 1;
        while (k < c.size() && c[k] == c[u]) k++;
        int cnt = k - u;

        for (int i = 0; c[u] * i <= target && i <= cnt; i++) {
            dfs(c, target - i * c[u], k);
            path.push_back(c[u]);
        }

        for (int i = 0; c[u] * i <= target && i <= cnt; i++) path.pop_back();
    }
};

void OutputBasicArray2D(vector<vector<int>> &nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (i > 0 && i < nums.size()) cout << ' ';
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", " << endl;
    }
    cout << "]" << endl;
}

int main() {

    vector<int> c = {10, 1, 2, 7, 6, 1, 5};
    int target = 8;
    vector<vector<int>> res = Solution().combinationSum2(c, target);
    OutputBasicArray2D(res);

    return 0;
}
