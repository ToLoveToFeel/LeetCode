// Created by WXX on 2021/4/7 19:14
#include <iostream>
#include <vector>

using namespace std;

// 思路，删除最后和nums[0]相等的数据，然后二分出分界点，最后二分出结果
// 删除最后和nums[0]相等的数据之后就和 Leetcode 0033 搜索旋转排序数组 一样了
/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了60.01%的用户
 * 内存消耗：13.5 MB, 在所有 C++ 提交中击败了85.84%的用户
 */
class Solution {
public:
    bool search(vector<int> &nums, int target) {

        int R = nums.size() - 1;
        while (R >= 0 && nums[R] == nums[0]) R--;
        if (R < 0) return nums[0] == target;  // 说明所有的数都一样

        // 二分出分界点(如 4,5,6,7,0,1,2 则返回7的下标3)
        int l = 0, r = R;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid - 1;
        }

        // 寻找target在哪一有序区间中
        if (target >= nums[0]) l = 0;
        else l++, r = R;

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }

        return nums[r] == target;
    }
};

int main() {

//    vector<int> nums = {2, 5, 6, 0, 0, 1, 2};
//    cout << Solution().search(nums, 2) << endl;  // true
//    cout << Solution().search(nums, 0) << endl;  // true
//    cout << Solution().search(nums, 3) << endl;  // false

    vector<int> nums = {1, 3};
    cout << Solution().search(nums, 0) << endl;  // true

    return 0;
}
