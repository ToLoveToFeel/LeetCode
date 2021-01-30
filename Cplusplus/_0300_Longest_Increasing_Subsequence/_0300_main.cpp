// Created by WXX on 2021/1/30 16:58
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：344 ms, 在所有 C++ 提交中击败了40.59%的用户
 * 内存消耗：10.3 MB, 在所有 C++ 提交中击败了66.35%的用户
 */
class Solution {
public:
    int lengthOfLIS(vector<int> &nums) {

        int n = nums.size();
        int res = 1;
        vector<int> f(n);
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    f[i] = max(f[i], f[j] + 1);
            res = max(res, f[i]);
        }
        return res;
    }
};

int main() {

    vector<int> nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};  // 6
    cout << Solution().lengthOfLIS(nums) << endl;

    return 0;
}
