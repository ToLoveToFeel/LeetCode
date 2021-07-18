// Created by WXX on 2021/7/18 14:56
#include <iostream>

using namespace std;

class Solution {
public:
    int mod = 1e9 + 7;

    int fib(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1, c;
        for (int i = 0; i < n - 1; i++) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return c;
    }
};

int main() {

    cout << Solution().fib(5) << endl;  // 5

    return 0;
}
