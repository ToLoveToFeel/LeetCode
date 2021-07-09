// Created by WXX on 2021/7/9 9:28
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了74.19%的用户
 * 内存消耗：18.5 MB, 在所有 C++ 提交中击败了5.14%的用户
 */
class Solution {
public:
    int majorityElement(vector<int> &nums) {
        int n = nums.size();
        unordered_map<int, int> cnt;  // (数据，次数)
        for (auto x : nums) cnt[x]++;
        for (auto &[k, v] : cnt)
            if (v > n / 2)
                return k;
        return -1;
    }
};

int main() {

    vector<int> nums = {1, 2, 5, 9, 5, 9, 5, 5, 5};
    cout << Solution().majorityElement(nums) << endl;  // 5

    return 0;
}
