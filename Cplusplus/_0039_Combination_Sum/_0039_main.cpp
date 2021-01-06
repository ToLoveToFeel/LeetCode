#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了92.66%的用户
 * 内存消耗：11.4 MB, 在所有 C++ 提交中击败了48.70%的用户
 */
class Solution {
public:

    vector<vector<int>> ans;
    vector<int> path;

    vector<vector<int>> combinationSum(vector<int> &c, int target) {
        dfs(c, target, 0);
        return ans;
    }

    void dfs(vector<int> &c, int target, int u) {

        if (target == 0) {
            ans.push_back(path);
            return;
        }
        if (u == c.size()) return;

        for (int i = 0; c[u] * i <= target; i++) {
            dfs(c, target - i * c[u], u + 1);
            path.push_back(c[u]);
        }

        for (int i = 0; c[u] * i <= target; i++) path.pop_back();
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

    vector<int> c = {2, 3, 5};
    int target = 8;
    vector<vector<int>> res = Solution().combinationSum(c, target);
    OutputBasicArray2D(res);

    return 0;
}
