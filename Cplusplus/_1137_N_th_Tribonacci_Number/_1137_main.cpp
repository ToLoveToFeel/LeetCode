// Created by ToLoveToFeel on 2021/8/8 11:15
#include <iostream>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.9 MB, 在所有 C++ 提交中击败了48.36%的用户
 */
class Solution {
public:
    int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int a = 0, b = 1, c = 1, d;
        for (int i = 0; i < n - 2; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
};

int main() {

    cout << Solution().tribonacci(4) << endl;  // 4
    cout << Solution().tribonacci(25) << endl;  // 1389537

    return 0;
}
