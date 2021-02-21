// Created by WXX on 2021/2/21 9:19
#include <iostream>
#include <vector>
#include <set>

using namespace std;

/**
 * 执行用时：224 ms, 在所有 C++ 提交中击败了69.01%的用户
 * 内存消耗：76.9 MB, 在所有 C++ 提交中击败了8.89%的用户
 */
class Solution {
public:
    int longestSubarray(vector<int> &nums, int limit) {

        multiset<int> s;
        int res = 0;
        for (int i = 0, j = 0; i < nums.size(); i++) {
            s.insert(nums[i]);
            while (*s.rbegin() - *s.begin() > limit) s.erase(s.find(nums[j++]));
            res = max(res, i - j + 1);
        }
        return res;
    }
};

int main() {

    vector<int> nums1 = {8, 2, 4, 7};
    cout << Solution().longestSubarray(nums1, 4) << endl;  // 2

    vector<int> nums2 = {10, 1, 2, 4, 7, 2};
    cout << Solution().longestSubarray(nums2, 5) << endl;  // 4

    vector<int> nums3 = {4, 2, 2, 2, 4, 4, 2, 2};
    cout << Solution().longestSubarray(nums3, 0) << endl;  // 3

    return 0;
}
