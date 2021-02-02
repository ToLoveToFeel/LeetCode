// Created by WXX on 2021/2/2 22:59
#include <iostream>

using namespace std;

typedef long long LL;

class Solution {
public:
    int integerReplacement(int n) {

        return f(n);
    }

    int f(LL n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return f(n / 2) + 1;
        return min(f(n + 1), f(n - 1)) + 1;
    }
};

int main() {

    cout << Solution().integerReplacement(8) << endl;  // 3
    cout << Solution().integerReplacement(7) << endl;  // 4

    return 0;
}
