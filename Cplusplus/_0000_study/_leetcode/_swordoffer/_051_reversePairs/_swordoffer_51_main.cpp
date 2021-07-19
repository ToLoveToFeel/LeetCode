// Created by WXX on 2021/7/19 19:59
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：152 ms, 在所有 C++ 提交中击败了96.98%的用户
 * 内存消耗：43.3 MB, 在所有 C++ 提交中击败了68.67%的用户
 */
class Solution {
public:
    vector<int> tmp;

    int reversePairs(vector<int> &nums) {
        int n = nums.size();
        tmp.resize(n);
        return merge_sort(nums, 0, nums.size() - 1);
    }

    int merge_sort(vector<int> &nums, int l, int r) {
        if (l >= r) return 0;

        int mid = l + r >> 1;
        int res = merge_sort(nums, l, mid) + merge_sort(nums, mid + 1, r);

        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r)
            if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else {
                tmp[k++] = nums[j++];
                res += mid - i + 1;
            }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];

        for (int i = l, j = 0; i <= r; i++, j++) nums[i] = tmp[j];
        return res;
    }
};

int main() {

    vector<int> nums = {7, 5, 6, 4};
    cout << Solution().reversePairs(nums) << endl;  // 5

    return 0;
}
