// Created by WXX on 2021/4/28 9:12
#include <iostream>
#include <cmath>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.9 MB, 在所有 C++ 提交中击败了13.41%的用户
 */
class Solution {
public:
    bool judgeSquareSum(int c) {
        for (long long i = 0; i * i <= c; i++) {
            int j = sqrt(c - i * i);
            if (i * i + j * j == c)
                return true;
        }
        return false;
    }
};

int main() {

    cout << Solution().judgeSquareSum(5) << endl;  // true

    return 0;
}
