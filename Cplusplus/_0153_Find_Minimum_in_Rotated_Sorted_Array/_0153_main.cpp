// Created by WXX on 2021/1/22 14:50
#include <iostream>
#include <vector>

using namespace std;

// 整数二分
/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了78.71%的用户
 * 内存消耗：9.9 MB, 在所有 C++ 提交中击败了62.41%的用户
 */
class Solution {
public:
    int findMin(vector<int> &nums) {

        int l = 0, r = nums.size() - 1;
        if (nums[r] >= nums[l]) return nums[0];

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[r];
    }
};

int main() {

    vector<int> nums = {3, 4, 5, 1, 2};
    cout << Solution().findMin(nums) << endl;

    return 0;
}