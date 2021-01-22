// Created by WXX on 2021/1/22 17:47
#include <iostream>
#include <vector>

using namespace std;

/**
 * https://www.bilibili.com/video/BV1Jz4y1Q7oF  时间：80:00
 * 执行用时：8 ms, 在所有 C++ 提交中击败了79.05%的用户
 * 内存消耗：8.5 MB, 在所有 C++ 提交中击败了99.49%的用户
 */
class Solution {
public:
    int findPeakElement(vector<int> &nums) {

        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            // 不存在越界情况，如果越界，意味着mid = r，则l也必须为r，不能进入循环
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }
};

int main() {

    vector<int> nums = {1, 2, 1, 3, 5, 6, 4};
    cout << Solution().findPeakElement(nums) << endl;

    return 0;
}
