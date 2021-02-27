// Created by WXX on 2021/2/25 20:04
#include <iostream>
#include <vector>

using namespace std;

// Leetcode 300 LIS 简化版
/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了68.13%的用户
 * 内存消耗：10.1 MB, 在所有 C++ 提交中击败了48.16%的用户
 */
class Solution {
public:
    bool increasingTriplet(vector<int> &nums) {
        vector<int> q(2, INT_MAX);
        for (auto a : nums) {
            int k = 2;
            while (k > 0 && q[k - 1] >= a) k--;
            if (k == 2) return true;
            q[k] = a;
        }
        return false;
    }
};

int main() {

    vector<int> nums = {1, 2, 3, 4, 5};
    cout << Solution().increasingTriplet(nums) << endl;

    return 0;
}
