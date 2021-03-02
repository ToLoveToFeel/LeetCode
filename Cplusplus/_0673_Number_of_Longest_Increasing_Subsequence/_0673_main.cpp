// Created by WXX on 2021/3/2 14:54
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：188 ms, 在所有 C++ 提交中击败了28.31%的用户
 * 内存消耗：12.8 MB, 在所有 C++ 提交中击败了86.53%的用户
 */
class Solution {
public:
    int findNumberOfLIS(vector<int> &nums) {
        int n = nums.size();
        vector<int> f(n), g(n);

        int maxv = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            f[i] = g[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i]) {
                    if (f[i] < f[j] + 1) f[i] = f[j] + 1, g[i] = g[j];
                    else if (f[i] == f[j] + 1) g[i] += g[j];
                }
            if (maxv < f[i]) maxv = f[i], cnt = g[i];
            else if (maxv == f[i]) cnt += g[i];
        }
        return cnt;
    }
};

int main() {

    vector<int> nums = {1, 3, 5, 4, 7};
    cout << Solution().findNumberOfLIS(nums) << endl;  // 2

    return 0;
}
