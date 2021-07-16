// Created by WXX on 2021/7/16 21:43
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了89.23%的用户
 * 内存消耗：25.8 MB, 在所有 C++ 提交中击败了88.02%的用户
 */
class Solution {
public:
    int findUnsortedSubarray(vector<int> &nums) {
        int l = 0, r = nums.size() - 1;
        // 处理左端点
        while (l + 1 < nums.size() && nums[l + 1] >= nums[l]) l++;
        if (l == r) return 0;  // 说明整个数组都是升序的
        for (int i = l + 1; i < nums.size(); i++)
            while (l >= 0 && nums[l] > nums[i])
                l--;

        // 处理右端点
        while (r - 1 >= 0 && nums[r - 1] <= nums[r]) r--;
        for (int i = r - 1; i >= 0; i--)
            while (r < nums.size() && nums[r] < nums[i])
                r++;
        return r - l - 1;  // 区间(l, r)需要调整
    }
};

int main() {

    vector<int> nums = {2, 6, 4, 8, 10, 9, 15};
    cout << Solution().findUnsortedSubarray(nums) << endl;  // 5

    return 0;
}
