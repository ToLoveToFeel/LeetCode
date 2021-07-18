// Created by WXX on 2021/7/18 14:56
#include <iostream>

using namespace std;

class Solution {
public:
    int mod = 1e9 + 7;

    // f[0] = 1, f[1] = 1, f[n] = f[n - 1] + f[n - 2]
    int numWays(int n) {
        if (n <= 1) return 1;
        int a = 1, b = 1, c;
        for (int i = 0; i < n - 1; i++) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return c;
    }
};

int main() {

    cout << Solution().numWays(5) << endl;  // 8

    return 0;
}
