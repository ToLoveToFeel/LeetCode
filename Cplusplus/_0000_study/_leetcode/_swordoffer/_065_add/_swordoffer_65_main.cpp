// Created by WXX on 2021/7/20 17:38
#include <iostream>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.8 MB, 在所有 C++ 提交中击败了61.76%的用户
 */
class Solution {
public:
    int add(int a, int b) {
        if (!a) return b;
        int sum = a ^b, carry = (unsigned) (a & b) << 1;
        return add(carry, sum);
    }
};

int main() {

    cout << Solution().add(1, 2) << endl;  // 3
    cout << Solution().add(-1, 2) << endl;  // 1

    return 0;
}
