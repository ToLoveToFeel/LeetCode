// Created by WXX on 2021/5/31 20:28
#include <iostream>
#include <vector>
#include <bitset>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了99.15%的用户
 * 内存消耗：8.8 MB, 在所有 C++ 提交中击败了93.54%的用户
 */
class Solution {
public:
    bool canPartition(vector<int>& nums) {
        bitset<10001> f;
        f[0] = true;
        int s = 0;
        for (auto x : nums) {
            f |= f << x;
            s += x;
        }
        if (s % 2) return false;
        return f[s / 2];
    }
};

int main() {

    vector<int> nums = {1, 5, 11, 5};
    cout << Solution().canPartition(nums) << endl;  // true

    return 0;
}
