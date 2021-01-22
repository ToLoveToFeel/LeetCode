// Created by WXX on 2021/1/22 15:10
#include <iostream>
#include <vector>

using namespace std;

// 和Leetcode 0153唯一的区别是可能存在重复元素，删掉尾部和nums[0]的元素即可二分
/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了53.60%的用户
 * 内存消耗：11.9 MB, 在所有 C++ 提交中击败了93.88%的用户
 */
class Solution {
public:
    int findMin(vector<int> &nums) {

        int l = 0, r = nums.size() - 1;
        while (l < r && nums[l] == nums[r]) r--;
        if (nums[l] < nums[r]) return nums[l];
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[r];
    }
};

int main() {

    vector<int> nums = {2, 2, 2, 0, 1};
    cout << Solution().findMin(nums) << endl;

    return 0;
}
