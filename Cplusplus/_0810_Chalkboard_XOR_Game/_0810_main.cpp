// Created by WXX on 2021/5/22 9:16
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了94.29%的用户
 * 内存消耗：12.3 MB, 在所有 C++ 提交中击败了92.38%的用户
 */
class Solution {
public:
    bool xorGame(vector<int> &nums) {
        int s = 0;
        for (auto x : nums) s ^= x;
        return !s || nums.size() % 2 == 0;
    }
};

int main() {

    vector<int> nums = {1, 1, 2};
    cout << Solution().xorGame(nums) << endl;  // false

    return 0;
}
