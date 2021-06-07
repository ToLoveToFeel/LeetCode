// Created by WXX on 2021/6/7 9:22
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：212 ms, 在所有 C++ 提交中击败了34.22%的用户
 * 内存消耗：38.9 MB, 在所有 C++ 提交中击败了5.52%的用户
 */
class Solution {
public:
    int findTargetSumWays(vector<int> &a, int target) {
        if (target < -1000 || target > 1000) return 0;
        int n = a.size(), Offset = 1000;
        vector<vector<int>> f(n + 1, vector<int>(2001));
        f[0][Offset] = 1;  // 一个数都不选，总和为0是一种合法方案
        for (int i = 1; i <= n; i++)
            for (int j = -1000; j <= 1000; j++) {
                if (j - a[i - 1] >= -1000)
                    f[i][j + Offset] += f[i - 1][j - a[i - 1] + Offset];
                if (j + a[i - 1] <= 1000)
                    f[i][j + Offset] += f[i - 1][j + a[i - 1] + Offset];
            }
        return f[n][target + Offset];
    }
};

int main() {

    vector<int> nums = {1, 1, 1, 1, 1};
    cout << Solution().findTargetSumWays(nums, 3) << endl;  // 5

    return 0;
}
