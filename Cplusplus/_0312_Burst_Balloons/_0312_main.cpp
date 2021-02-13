// Created by WXX on 2021/1/31 22:36
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：752 ms, 在所有 C++ 提交中击败了48.19%的用户
 * 内存消耗：9.9 MB, 在所有 C++ 提交中击败了43.05%的用户
 */
class Solution {
public:
    int maxCoins(vector<int>& nums) {

        int n = nums.size();
        vector<int> a(n + 2, 1);
        for (int i = 1; i <= n; i++) a[i] = nums[i - 1];

        vector<vector<int>> f(n + 2, vector<int>(n + 2));
        for (int len = 3; len <= n + 2; len++)
            for (int i = 0; i + len - 1 <= n + 1; i++) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k++)
                    f[i][j] = max(f[i][j], f[i][k] + f[k][j] + a[i] * a[k] * a[j]);
            }
        return f[0][n + 1];
    }
};

int main() {

    vector<int> nums = {3, 1, 5, 8};
    cout << Solution().maxCoins(nums) << endl;  // 167

    return 0;
}
