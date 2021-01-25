// Created by WXX on 2021/1/25 23:35
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了97.58%的用户
 * 内存消耗：16.5 MB, 在所有 C++ 提交中击败了94.43%的用户
 */
class Solution {
public:
    int singleNumber(vector<int> &nums) {

        int res = 0;
        for (auto t : nums) res ^= t;
        return res;
    }
};

int main() {

    vector<int> nums = {4, 1, 2, 1, 2};
    cout << Solution().singleNumber(nums) << endl;  // 4

    return 0;
}
