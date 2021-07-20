// Created by WXX on 2021/7/20 17:00
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了56.14%的用户
 * 内存消耗：9.9 MB, 在所有 C++ 提交中击败了63.42%的用户
 */
class Solution {
public:
    bool isStraight(vector<int>& nums) {

        sort(nums.begin(), nums.end());
        int k = 0;
        while (!nums[k]) k++;
        for (int i = k + 1; i < 5; i++)
            if (nums[i] == nums[i - 1])
                return false;
        return nums.back() - nums[k] < 5;
    }
};

int main() {

    vector<int> nums = {0, 0, 1, 1, 3};
    cout << Solution().isStraight(nums) << endl;  // false

    return 0;
}
