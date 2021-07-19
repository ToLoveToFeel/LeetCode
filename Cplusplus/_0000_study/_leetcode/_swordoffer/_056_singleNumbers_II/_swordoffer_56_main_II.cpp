// Created by WXX on 2021/7/19 21:12
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：40 ms, 在所有 C++ 提交中击败了72.39%的用户
 * 内存消耗：15.8 MB, 在所有 C++ 提交中击败了38.22%的用户
 */
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int x : nums) cnt += (x >> i & 1);
            if (cnt % 3) res += 1 << i;
        }
        return res;
    }
};

int main() {

    vector<int> nums = {3, 4, 3, 3};
    cout << Solution().singleNumber(nums);  // 4

    return 0;
}
