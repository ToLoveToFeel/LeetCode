// Created by WXX on 2021/7/18 11:05
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了95.79%的用户
 * 内存消耗：22.4 MB, 在所有 C++ 提交中击败了78.68%的用户
 */
class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        for (int i = 0; i < nums.size(); i++) {
            int x = abs(nums[i]);
            if (nums[x] < 0) return x;
            nums[x] *= -1;
        }
        return 0;
    }
};

int main() {

    vector<int> nums = {2, 3, 1, 0, 2, 5, 3};
    cout << Solution().findRepeatNumber(nums) << endl;  // 2

    return 0;
}
