// Created by WXX on 2021/6/5 20:27
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了80.60%的用户
 * 内存消耗：10.6 MB, 在所有 C++ 提交中击败了30.97%的用户
 */
class Solution {
public:
    int minMoves2(vector<int> &nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int res = 0;
        for (int i = 0; i < n; i++) res += abs(nums[i] - nums[n / 2]);
        return res;
    }
};

int main() {

    vector<int> nums = {1, 2, 3};
    cout << Solution().minMoves2(nums) << endl;  // 2

    return 0;
}
