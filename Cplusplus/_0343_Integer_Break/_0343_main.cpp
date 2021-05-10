// Created by WXX on 2021/5/10 22:12
#include <iostream>

using namespace std;

class Solution {
public:
    int integerBreak(int n) {
        if (n <= 3) return 1 * (n - 1);
        int p = 1;
        while (n >= 5) n -= 3, p *= 3;  // 结束循环后n只可能为2、3或者4
        return p * n;
    }
};

int main() {

    cout << Solution().integerBreak(2) << endl;  // 1

    return 0;
}
