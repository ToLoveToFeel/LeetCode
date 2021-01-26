// Created by WXX on 2021/1/26 16:37
#include <iostream>

using namespace std;

// lowbit
/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了39.86%的用户
 * 内存消耗：5.9 MB, 在所有 C++ 提交中击败了90.67%的用户
 */
class Solution {
public:
    int hammingWeight(uint32_t n) {

        int res = 0;
        while (n) n -= (n & -n), res++;
        return res;
    }
};

int main() {

    cout << Solution().hammingWeight(8) << endl;  // 1
    cout << Solution().hammingWeight(UINT32_MAX) << endl;  // 32

    return 0;
}