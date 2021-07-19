// Created by WXX on 2021/7/19 20:29
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了95.84%的用户
 * 内存消耗：16.7 MB, 在所有 C++ 提交中击败了39.29%的用户
 */
class Solution {
public:
    int missingNumber(vector<int> &nums) {

        int n = nums.size();
        if (nums.back() == n - 1) return n;

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] != mid) r = mid;
            else l = mid + 1;
        }
        return r;
    }
};

int main() {

    vector<int> nums = {0, 1, 3};
    cout << Solution().missingNumber(nums) << endl;  // 2

    return 0;
}
