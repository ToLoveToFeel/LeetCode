// Created by WXX on 2021/7/14 9:55
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

/**
 * 执行用时：188 ms, 在所有 C++ 提交中击败了92.26%的用户
 * 内存消耗：62.4 MB, 在所有 C++ 提交中击败了76.51%的用户
 */
class Solution {
public:
    const int mod = 1e9 + 7;

    int minAbsoluteSumDiff(vector<int> &nums1, vector<int> &nums2) {
        int n = nums1.size();
        vector<int> a(nums1);  // a是nums1排好序的结果
        sort(a.begin(), a.end());
        int sum = 0, d = 0;
        for (int i = 0; i < n; i++) {
            int t = abs(nums1[i] - nums2[i]);
            sum = (sum + t) % mod;
            // 返回a中大于等于nums2[i]的最小的数
            int index = lower_bound(a.begin(), a.end(), nums2[i]) - a.begin();
            if (index < n) d = max(d, t - abs(a[index] - nums2[i]));
            if (index > 0) d = max(d, t - abs(a[index - 1] - nums2[i]));
        }
        return (sum - d + mod) % mod;
    }
};

int main() {

    vector<int> nums1 = {1, 28, 21};
    vector<int> nums2 = {9, 21, 20};
    cout << Solution().minAbsoluteSumDiff(nums1, nums2) << endl;  // 9

    return 0;
}
