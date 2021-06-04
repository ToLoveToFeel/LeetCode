// Created by WXX on 2021/6/4 10:05
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：44 ms, 在所有 C++ 提交中击败了66.63%的用户
 * 内存消耗：27.6 MB, 在所有 C++ 提交中击败了64.99%的用户
 */
class Solution {
public:
    int minMoves(vector<int>& nums) {
        int minv = INT_MAX;
        for (int x : nums) minv = min(minv, x);
        int res = 0;
        for (auto x : nums) res += x - minv;
        return res;
    }
};

int main() {

    vector<int> nums = {1, 2, 3};
    cout << Solution().minMoves(nums) << endl;  // 3

    return 0;
}
