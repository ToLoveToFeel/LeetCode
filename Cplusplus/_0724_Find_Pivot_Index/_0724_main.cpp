// Created by WXX on 2021/1/28 10:34
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：52 ms, 在所有 C++ 提交中击败了47.62%的用户
 * 内存消耗：30.1 MB, 在所有 C++ 提交中击败了98.95%的用户
 */
class Solution {
public:
    int pivotIndex(vector<int> &nums) {

        int n = nums.size();

        int s = 0;
        for (int i = 0; i < n; i++) s += nums[i];

        for (int i = 0, ls = 0; i < n; i++) {
            if (ls == s - ls - nums[i]) return i;
            ls += nums[i];
        }
        return -1;
    }
};

int main() {

    vector<int> nums = {-1, -1, -1, 0, 1, 1};
    cout << Solution().pivotIndex(nums) << endl;  // 0

    return 0;
}
