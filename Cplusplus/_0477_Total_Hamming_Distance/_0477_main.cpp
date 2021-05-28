// Created by WXX on 2021/5/28 9:02
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：44 ms, 在所有 C++ 提交中击败了90.76%的用户
 * 内存消耗：18.5 MB, 在所有 C++ 提交中击败了45.29%的用户
 */
class Solution {
public:
    int totalHammingDistance(vector<int> &nums) {
        int res = 0;
        for (int i = 0; i <= 30; i++) {
            int x = 0, y = 0;  // x表示对应为1的数量，y表示对应为0的数量
            for (auto c : nums)
                if (c >> i & 1) x++;
                else y++;
            res += x * y;
        }
        return res;
    }
};

int main() {

    vector<int> nums = {4, 12, 2};
    cout << Solution().totalHammingDistance(nums) << endl;  // 6

    return 0;
}
