// Created by WXX on 2021/6/2 9:00
#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

/**
 * 执行用时：212 ms, 在所有 C++ 提交中击败了33.29%的用户
 * 内存消耗：98.1 MB, 在所有 C++ 提交中击败了7.13%的用户
 */
class Solution {
public:
    bool checkSubarraySum(vector<int> &nums, int k) {
        int n = nums.size();
        vector<int> s(n + 1);
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];

        unordered_set<int> hash;  // 存储余数
        for (int i = 2; i <= n; i++) {
            hash.insert(s[i - 2] % k);
            if (hash.count(s[i] % k)) return true;
        }
        return false;
    }
};

int main() {

    vector<int> nums = {23, 2, 4, 6, 7};
    cout << Solution().checkSubarraySum(nums, 6) << endl;  // true

    return 0;
}
