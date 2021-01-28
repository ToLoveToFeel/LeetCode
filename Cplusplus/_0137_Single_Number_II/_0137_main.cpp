// Created by WXX on 2021/1/26 14:24
#include <iostream>
#include <vector>

using namespace std;

// 该类题目套路：真值表化简(数字电路)，了解即可
/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了99.51%的用户
 * 内存消耗：9.2 MB, 在所有 C++ 提交中击败了97.59%的用户
 */
class Solution {
public:
    int singleNumber(vector<int> &nums) {

        int two = 0, one = 0;
        for (auto x : nums) {
            one = (one ^ x) & ~two;
            two = (two ^ x) & ~one;
        }
        return one;
    }
};

int main() {

    vector<int> nums = {2, 2, 1, 2};
    cout << Solution().singleNumber(nums) << endl;  // 1

    return 0;
}
