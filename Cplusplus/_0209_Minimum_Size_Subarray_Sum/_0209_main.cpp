// Created by WXX on 2021/1/27 15:16
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了96.37%的用户
 * 内存消耗：10.1 MB, 在所有 C++ 提交中击败了90.85%的用户
 */
class Solution {
public:
    int minSubArrayLen(int s, vector<int> &nums) {

        int res = INT_MAX;
        for (int i = 0, j = 0, sum = 0; i < nums.size(); i++) {
            sum += nums[i];
            while (sum - nums[j] >= s) sum -= nums[j++];
            if (sum >= s) res = min(res, i - j + 1);
        }
        if (res == INT_MAX) res = 0;
        return res;
    }
};

int main() {

    int s = 7;
    vector<int> nums = {2, 3, 1, 2, 4, 3};
    cout << Solution().minSubArrayLen(s, nums) << endl;  // 2

    return 0;
}
