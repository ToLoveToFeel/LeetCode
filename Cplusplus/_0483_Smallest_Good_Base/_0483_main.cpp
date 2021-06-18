// Created by WXX on 2021/6/18 15:29
#include <iostream>
#include <cmath>

using namespace std;

class Solution {
public:
    string smallestGoodBase(string n) {
        typedef long long LL;
        LL N = stoll(n);
        for (int t = log2(N) + 1; t >= 3; t--) {
            LL k = pow(N, 1.0 / (t - 1));
            LL r = 0;
            for (int i = 0; i < t; i++) r = r * k + 1;
            if (r == N) return to_string(k);
        }
        return to_string(N - 1);
    }
};

int main() {

    cout << Solution().smallestGoodBase("13") << endl;  // 3
    cout << Solution().smallestGoodBase("1000000000000000000") << endl;  // 999999999999999999

    return 0;
}
