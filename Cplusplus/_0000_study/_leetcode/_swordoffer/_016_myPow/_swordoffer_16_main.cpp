// Created by WXX on 2021/7/18 15:58
#include <iostream>

using namespace std;

class Solution {
public:
    double myPow(double x, int n) {
        typedef long long LL;

        bool is_minus = n < 0;
        double res = 1;
        LL k = abs(LL(n));
        while (k) {
            if (k & 1) res *= x;
            x *= x;
            k >>= 1;
        }
        if (is_minus) res = 1.0 / res;
        return res;
    }
};

int main() {

    cout << Solution().myPow(2.0, 10) << endl;  // 1024.0
    cout << Solution().myPow(2.0, -2) << endl;  // 0.25

    return 0;
}
