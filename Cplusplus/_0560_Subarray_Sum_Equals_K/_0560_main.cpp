// Created by WXX on 2021/5/29 14:12
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：104 ms, 在所有 C++ 提交中击败了44.31%的用户
 * 内存消耗：41.7 MB, 在所有 C++ 提交中击败了7.23%的用户
 */
class Solution {
public:
    int subarraySum(vector<int> &nums, int k) {
        int n = nums.size();
        vector<int> s(n + 1);
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];
        unordered_map<int, int> hash;  // (数据，出现次数)
        hash[0] = 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += hash[s[i] - k];
            hash[s[i]]++;
        }
        return res;
    }
};

int main() {

    vector<int> nums = {1, 1, 1};
    cout << Solution().subarraySum(nums, 2) << endl;  // 2

    return 0;
}
