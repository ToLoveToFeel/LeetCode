// Created by WXX on 2021/1/26 16:32
#include <iostream>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.6 MB, 在所有 C++ 提交中击败了99.57%的用户
 */
class Solution {
public:
    uint32_t reverseBits(uint32_t n) {

        uint32_t res = 0;
        for (int i = 0; i < 32; i++)
            res = (res * 2) + (n >> i & 1);
        return res;
    }
};

int main() {

    cout << Solution().reverseBits(43261596) << endl;  // 964176192

    return 0;
}
