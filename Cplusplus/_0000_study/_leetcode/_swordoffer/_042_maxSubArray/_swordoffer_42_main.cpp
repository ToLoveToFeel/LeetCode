// Created by WXX on 2021/7/17 14:55
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了85.71%的用户
 * 内存消耗：22.2 MB, 在所有 C++ 提交中击败了95.91%的用户
 */
class Solution {
public:
    int maxSubArray(vector<int> &nums) {
        int res = nums[0], f = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            f = max(0, f) + nums[i];
            res = max(res, f);
        }
        return res;
    }
};

int main() {

    vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    cout << Solution().maxSubArray(nums) << endl;  // 6

    return 0;
}
