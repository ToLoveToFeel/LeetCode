// Created by WXX on 2021/5/31 15:58
#include <iostream>
#include <algorithm>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.9 MB, 在所有 C++ 提交中击败了18.60%的用户
 */
class Solution {
public:
    string toHex(unsigned int num) {
        if (!num) return "0";
        string res, nums = "0123456789abcdef";
        while (num) {
            res += nums[num & 0xf];
            num >>= 4;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};

int main() {

    cout << Solution().toHex(26) << endl;  // 1a
    cout << Solution().toHex(0) << endl;  // 0
    cout << Solution().toHex(-1) << endl;  // ffffffff

    return 0;
}
