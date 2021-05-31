// Created by WXX on 2021/5/31 20:19
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：92 ms, 在所有 C++ 提交中击败了95.41%的用户
 * 内存消耗：9.6 MB, 在所有 C++ 提交中击败了65.05%的用户
 */
class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int s = 0;
        for (auto x : nums) s += x;
        if (s % 2 != 0) return false;

        s /= 2;
        vector<int> f(s + 1);
        f[0] = 1;
        for (int x : nums)
            for (int j = s; j >= x; j--)
                f[j] |= f[j - x];
        return f[s];
    }
};

int main() {

    vector<int> nums = {1, 5, 11, 5};
    cout << Solution().canPartition(nums) << endl;  // true

    return 0;
}
