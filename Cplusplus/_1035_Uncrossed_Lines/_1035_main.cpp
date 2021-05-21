// Created by WXX on 2021/5/21 8:30
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：24 ms, 在所有 C++ 提交中击败了29.00%的用户
 * 内存消耗：12.6 MB, 在所有 C++ 提交中击败了46.16%的用户
 */
class Solution {
public:
    int maxUncrossedLines(vector<int> &nums1, vector<int> &nums2) {
        // LCS
        int n = nums1.size(), m = nums2.size();
        vector<vector<int>> f(n + 1, vector<int>(m + 1));
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = max(f[i - 1][j], f[i][j - 1]);
                if (nums1[i - 1] == nums2[j - 1]) f[i][j] = max(f[i][j], f[i - 1][j - 1] + 1);
            }
        return f[n][m];
    }
};

int main() {

    vector<int> nums1 = {1, 4, 2}, nums2 = {1, 2, 4};
    cout << Solution().maxUncrossedLines(nums1, nums2) << endl;  // 2

    return 0;
}
