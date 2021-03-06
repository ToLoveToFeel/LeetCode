// Created by WXX on 2021/2/22 21:48
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了70.06%的用户
 * 内存消耗：16.7 MB, 在所有 C++ 提交中击败了98.18%的用户
 */
class Solution {
public:
    void wiggleSort(vector<int> &nums) {

        int n = nums.size();
        auto midptr = nums.begin() + n / 2;
        nth_element(nums.begin(), midptr, nums.end());  // 返回第midptr+1小的数据
        int mid = *midptr;  // mid是nums的中位数

        #define A(i) nums[(i * 2 + 1) % (n | 1)]
        // 三数排序：Leetcode 75
        for (int i = 0, j = 0, k = n - 1; i <= k;) {
            if (A(i) > mid) swap(A(i++), A(j++));  // 较大的数放在前面
            else if (A(i) < mid) swap(A(i), A(k--));
            else i++;
        }
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    // [1, 6, 1, 5, 1, 4]
    vector<int> nums = {1, 5, 1, 1, 6, 4};
    Solution().wiggleSort(nums);
    OutputBasicArray1D(nums);

    return 0;
}
