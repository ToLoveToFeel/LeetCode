// Created by WXX on 2021/7/8 9:24
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：60 ms, 在所有 C++ 提交中击败了67.12%的用户
 * 内存消耗：36.7 MB, 在所有 C++ 提交中击败了5.13%的用户
 */
class Solution {
public:
    int numSubarraysWithSum(vector<int> &nums, int goal) {
        int n = nums.size();
        vector<int> s(n + 1);
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];

        int res = 0;
        unordered_map<int, int> cnt;
        for (int i = 1; i <= n; i++) {
            cnt[s[i - 1]]++;
            res += cnt[s[i] - goal];
        }
        return res;
    }
};

int main() {

    vector<int> nums = {1, 0, 1, 0, 1};
    cout << Solution().numSubarraysWithSum(nums, 2) << endl;  // 4

    return 0;
}
