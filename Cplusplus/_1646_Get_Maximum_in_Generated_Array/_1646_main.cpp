// Created by WXX on 2021/8/23 10:08
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.1 MB, 在所有 C++ 提交中击败了65.68%的用户
 */
class Solution {
public:
    int getMaximumGenerated(int n) {

        if (n == 0) return 0;

        vector<int> nums(n + 1);
        nums[0] = 0, nums[1] = 1;
        for (int i = 1; i <= n; i++) {
            if (i * 2 <= n) nums[i * 2] = nums[i];
            if (i * 2 + 1 <= n) nums[i * 2 + 1] = nums[i] + nums[i + 1];
        }

        int res = 0;
        for (int i = 0; i <= n; i++) res = max(res, nums[i]);
        return res;
    }
};

int main() {

    cout << Solution().getMaximumGenerated(7) << endl;  // 3
    cout << Solution().getMaximumGenerated(2) << endl;  // 1
    cout << Solution().getMaximumGenerated(3) << endl;  // 2

    return 0;
}
